package com.chris.feed.controller;

import com.chris.feed.dto.LiveScore;
import com.chris.feed.dto.LiveStatus;
import com.chris.feed.dto.Sport;
import com.chris.feed.dto.TypeStatus;
import com.chris.feed.service.SportFeedsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FeedController {

    private final SportFeedsService sportFeedsService;

    @ApiOperation(value = "Get All livescores", response = LiveScore.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved livescores"),
    })
    @GetMapping("/livescore")
    public LiveScore getFeeds(@RequestParam(required = false) final List<TypeStatus> statuses, @RequestParam(required = false) final LiveStatus liveStatus) {

        return sportFeedsService.getSportFeeds(statuses, liveStatus);
    }
}
