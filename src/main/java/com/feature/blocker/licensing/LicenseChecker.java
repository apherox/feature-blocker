package com.feature.blocker.licensing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * This class checks if License bean is present, if not
 * that means that no license is present and License bean is not loaded.
 */
@Slf4j
@Component
@ConditionalOnMissingBean(License.class)
public class LicenseChecker implements ApplicationContextAware {

    private ApplicationContext ctx;

    @PostConstruct
    public void init() {

        log.error("Licence not found. Shutting down immediately!");

        SpringApplication.exit(ctx);

    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

}
