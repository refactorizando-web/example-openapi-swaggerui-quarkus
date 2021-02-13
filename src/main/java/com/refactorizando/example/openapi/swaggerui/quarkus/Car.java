package com.refactorizando.example.openapi.swaggerui.quarkus;

public class Car {

  private Long id;

  private String model;

  private String color;

  private String brand;

  public Car(Long id, String model, String color, String brand) {
    this.model = model;
    this.color = color;
    this.brand = brand;
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
