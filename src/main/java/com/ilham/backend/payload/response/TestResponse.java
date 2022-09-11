package com.ilham.backend.payload.response;

public class TestResponse {

    private String message;

    public TestResponse() {
    }

    public TestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
