package com.chris.feed.service.impl;

import com.chris.feed.dto.LiveStatus;
import com.chris.feed.dto.Sport;
import com.chris.feed.dto.TypeStatus;
import com.chris.feed.repo.SportFeedRepo;
import com.chris.feed.service.SportFeedsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SportFeedsServiceImpl implements SportFeedsService {

    private final SportFeedRepo sportFeedRepo;

    private final ObjectMapper mapper;

    @Override
    public List<Sport> getSportFeeds(List<TypeStatus> typeStatuses, LiveStatus liveStatus) {
        return ((typeStatuses != null && typeStatuses.size() != 0) ? sportFeedRepo.findByStatusIn(typeStatuses.stream()
                                                                                                              .map(TypeStatus::getTypeStatus)
                                                                                                              .collect(Collectors.toList()))
                                                                   : sportFeedRepo.findAll())
            .stream()
            .filter(t -> liveStatus != null ? checkLiveStatus(t.getLiveDetails(), liveStatus) : Boolean.TRUE)
            .map(m -> {
                try {
                    return mapper.readValue(m.getRawValue(), Sport.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return Sport.builder().build();
            }).

                collect(Collectors.toList());
    }


    private boolean checkLiveStatus(String liveDetails, LiveStatus liveStatus) {
        switch (liveStatus) {
            case FULLTIME:
            case HALFTIME:
            case CANCELED:
                return liveDetails.equalsIgnoreCase(liveStatus.getStatus());
            case FIRSTHALF:
                if (StringUtils.isNumeric(liveDetails)) {
                    int minute = Integer.parseInt(liveDetails);
                    return minute >= 0 && minute <= 45;
                }
                break;
            case SECONDHALF:
                if (StringUtils.isNumeric(liveDetails)) {
                    int minute = Integer.parseInt(liveDetails);
                    return minute > 45;
                } else if (liveDetails.equals("45+")) {
                    return Boolean.TRUE;
                }
                break;
        }
        return Boolean.FALSE;
    }
}
