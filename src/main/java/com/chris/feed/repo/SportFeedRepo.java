package com.chris.feed.repo;

import com.chris.feed.model.SportFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportFeedRepo extends JpaRepository<SportFeed, String> {

    List<SportFeed> findByStatusIn(List<String> status);
}
