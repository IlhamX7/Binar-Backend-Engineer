package com.ilham.backend.payload.response;

import com.ilham.backend.models.Product;

public class ProductResponse {

    private String status;

    private Product result;

    public ProductResponse() {
    }

    public ProductResponse(String status, Product result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getResult() {
        return result;
    }

    public void setResult(Product result) {
        this.result = result;
    }
}
