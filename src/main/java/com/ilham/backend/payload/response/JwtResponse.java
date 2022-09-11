package com.ilham.backend.payload.response;

public class JwtResponse {
  private String status;

  private String access_token;

  public JwtResponse(String status, String access_token) {
    this.status = status;
    this.access_token = access_token;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }
}
