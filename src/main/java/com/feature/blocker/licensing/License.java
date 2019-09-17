package com.feature.blocker.licensing;

import com.feature.blocker.config.JsonPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.stream.Stream;

@Configuration
@ConditionalOnResource(resources = "classpath:features.lic")
@PropertySource(value = "classpath:features.lic", factory = JsonPropertySourceFactory.class)
@ConfigurationProperties
@Data
public class License {

    private List<String> features;

    public boolean verify(Feature[] feat) {
        return Stream.of(feat).map(Feature::name).allMatch(features::contains);
    }

}
