package com.chris.feed.service;

import com.chris.feed.dto.LiveScore;
import com.chris.feed.dto.LiveStatus;
import com.chris.feed.dto.Sport;
import com.chris.feed.dto.TypeStatus;
import com.chris.feed.model.SportFeed;

import java.util.List;

public interface SportFeedsService {
    LiveScore getSportFeeds(final List<TypeStatus> typeStatuses, final LiveStatus liveStatus);
}
