package com.example.languagecourseclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RefreshScope
public class ClientController {

    @Autowired
    @Lazy
    private RestTemplate template;

    @Value("${languagecourse.provider.url}")
    private String url;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<String>> getCourses() {
        List<String> courses = template.getForObject(url, List.class);
        return ResponseEntity.ok(courses);
    }


}
