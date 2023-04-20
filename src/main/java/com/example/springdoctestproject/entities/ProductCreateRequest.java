package com.example.springdoctestproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreateRequest {
  private String name;
  private Double price;
}

