package com.chris.feed;

import com.chris.feed.dto.Sport;
import com.chris.feed.model.SportFeed;
import com.chris.feed.repo.SportFeedRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.net.URL;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
@RequiredArgsConstructor
@Slf4j
public class FeedApplication implements CommandLineRunner {

    private final SportFeedRepo sportFeedRepo;

    @Value("${application.external.url}")
    private String externalUrl;

    public static void main(String[] args) {
        SpringApplication.run(FeedApplication.class, args);
    }

    // On Startup application will read JSON from url and store in a database table (In this case using H2 inmemory database ).
    //Future improvements handle unrecognized parameters

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting Loading of JSON file from URL: {}", externalUrl);
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(externalUrl);
        mapper.readValue(url, new TypeReference<List<Sport>>() {})
              .forEach(m -> {
                  try {
                      sportFeedRepo.save(SportFeed.builder()
                                                  .id(m.getId())
                                                  .firstName(m.getName())
                                                  .competition(m.getCompetition())
                                                  .liveDetails(m.getLiveStatus())
                                                  .status(m.getStatus().getType())
                                                  .rawValue(mapper.writeValueAsString(m))
                                                  .build());
                  } catch (JsonProcessingException e) {
                      e.printStackTrace();
                  }
              });
        log.info("Loading of data complete, total number of feeds loaded: {}", sportFeedRepo.count());
    }


}
