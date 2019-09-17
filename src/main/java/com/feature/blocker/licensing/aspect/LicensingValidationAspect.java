package com.feature.blocker.licensing.aspect;

import com.feature.blocker.licensing.License;
import com.feature.blocker.licensing.Licensed;
import com.feature.blocker.licensing.exception.InvalidFeatureException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LicensingValidationAspect {

    @Autowired
    private License license;

    @Before("@annotation(a)")
    public void handle(JoinPoint jp, Licensed a) throws InvalidFeatureException {

        if (!license.verify(a.features())) {
            throw new InvalidFeatureException("You do not have the proper license to execute this functionality.\n");
        }

        log.debug("Licensed features verified: {}", a.features());
    }

}
