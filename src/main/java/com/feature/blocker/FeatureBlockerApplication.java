package com.feature.blocker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class FeatureBlockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureBlockerApplication.class, args);
        log.info("FeatureBlocker is ready!");
    }
}
