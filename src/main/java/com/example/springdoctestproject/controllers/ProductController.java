package com.example.springdoctestproject.controllers;

import com.example.springdoctestproject.entities.Product;
import com.example.springdoctestproject.entities.ProductCreateRequest;
import com.example.springdoctestproject.repositories.ProductRepository;
import com.example.springdoctestproject.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(summary = "Get all products", description = "Lists all products")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "List of products"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @GetMapping(value = "/products")
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @Operation(summary = "Get one product", description = "Gets one product by id")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Product"),
          @ApiResponse(responseCode = "404", description = "Product not found"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @GetMapping(value = "/products/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable String id) {
    Product product = productService.getProduct(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @Operation(summary = "Create product", description = "Creates a new product")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "202", description = "Product created"),
          @ApiResponse(responseCode = "500", description = "Internal server error")

      })
  @PostMapping(value = "/products")
  public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest product) {
    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
  }

  @Operation(summary = "Update product", description = "Updates a product")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Product updated"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PutMapping(value = "/products")
  public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
  }

  @Operation(summary = "Delete product", description = "Deletes a new product")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "204", description = "Product deleted"),
          @ApiResponse(responseCode = "404", description = "Product not found"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @DeleteMapping(value = "/products/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

