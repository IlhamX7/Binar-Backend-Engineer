package com.ilham.backend.controllers;

import com.ilham.backend.payload.response.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/products")
public class TestingController {

    @GetMapping("")
    public ResponseEntity<TestResponse> getTesting() {
        try {
            return new ResponseEntity<>(new TestResponse("Hello there"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new TestResponse("Failed"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
