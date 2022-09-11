package com.ilham.backend.payload.response;

import com.ilham.backend.models.User;

public class UserResponse {

    private String status;

    private User result;

    public UserResponse() {
    }

    public UserResponse(String status, User result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getResult() {
        return result;
    }

    public void setResult(User result) {
        this.result = result;
    }
}
