package com.ilham.backend.payload.response;

import com.ilham.backend.models.Product;

import java.util.List;

public class ProductsResponse {

    private String status;

    private List<Product> result;

    public ProductsResponse() {
    }

    public ProductsResponse(String status, List<Product> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getResult() {
        return result;
    }

    public void setResult(List<Product> result) {
        this.result = result;
    }
}
