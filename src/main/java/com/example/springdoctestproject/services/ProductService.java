package com.example.springdoctestproject.services;

import com.example.springdoctestproject.entities.Product;
import com.example.springdoctestproject.entities.ProductCreateRequest;
import com.example.springdoctestproject.exceptions.ItemNotFound;
import com.example.springdoctestproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Product getProduct(String id) {
    return productRepository.findById(id).orElseThrow(() -> new ItemNotFound("Product", id));
  }

  public Product createProduct(ProductCreateRequest productDTO) {
    return productRepository.save(toProduct(productDTO));
  }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProduct(String id) {
    if (productRepository.existsById(id))
      productRepository.deleteById(id);
    else
      throw new ItemNotFound("Product", id);
  }

  private Product toProduct(ProductCreateRequest productDTO) {
    return new Product(productDTO.getName(), productDTO.getPrice());
  }
}
