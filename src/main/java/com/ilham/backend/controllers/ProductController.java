package com.ilham.backend.controllers;

import com.ilham.backend.models.Product;
import com.ilham.backend.payload.request.ProductRequest;
import com.ilham.backend.payload.response.ProductResponse;
import com.ilham.backend.payload.response.ProductsResponse;
import com.ilham.backend.payload.response.StatusResponse;
import com.ilham.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        try {

            Product product = new Product();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setImageurl(request.getImageurl());
            productRepository.save(product);

            return new ResponseEntity<>(new ProductResponse("OK", product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ProductResponse("failed", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<ProductsResponse> getAllProduct() {
        try {
            List<Product> products = productRepository.findAll();
            return new ResponseEntity<>(new ProductsResponse("OK", products), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ProductsResponse("failed", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long id) {
        Optional<Product> productData = productRepository.findById(id);
        return productData.map(product -> new ResponseEntity<>(new ProductResponse("OK", product), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ProductResponse("04", null), HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest request) {
        Optional<Product> productId = productRepository.findById(id);
        if (productId.isPresent()) {

            Product product = productId.get();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setImageurl(request.getImageurl());
            productRepository.save(product);

            return new ResponseEntity<>(new ProductResponse("OK", product), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ProductResponse("failed", null), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> productId = productRepository.findById(id);
        if (productId.isPresent()) {
            productRepository.deleteById(productId.get().getId());
            return new ResponseEntity<>(new StatusResponse("OK", "deleted"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StatusResponse("failed", "not found"), HttpStatus.NOT_FOUND);
        }
    }

}
