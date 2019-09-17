package com.feature.blocker.web;

import com.feature.blocker.licensing.Feature;
import com.feature.blocker.licensing.Licensed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/features")
public class MainController {

    @GetMapping
    public ResponseEntity<String> home() {
       return new ResponseEntity<> ( "Hello from FeatureBlocker application.\n", OK);
    }

    @Licensed(features = Feature.FEATURE_1)
    @GetMapping("/1")
    public ResponseEntity<String> feature1() {
        return new ResponseEntity<> ("Feature 1 executed.\n", OK);
    }

    @Licensed(features = Feature.FEATURE_2)
    @GetMapping("/2")
    public ResponseEntity<String> feature2() {
        return new ResponseEntity<> ("Feature 2 executed.\n", OK);
    }

    // This feature is missing in features.lic file so invoking in should throw an exception
    @Licensed(features = Feature.FEATURE_3)
    @GetMapping("/3")
    public ResponseEntity<String> feature3() {
        return new ResponseEntity<> ("Feature 3 executed.\n", OK);
    }

}
