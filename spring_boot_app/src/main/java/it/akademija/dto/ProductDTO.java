package it.akademija.dto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class ProductDTO {
    private Long id;

    private Integer product_No;

    private String image_url;

    private BigDecimal price;

    private String category;

    private String brand;

    private String description;

    private Integer rating;

    private Integer quantity;


    public ProductDTO() {
    }

    public ProductDTO(Long id, Integer product_No, String image_url, BigDecimal price, String category, String brand, String description, Integer rating, Integer quantity) {
        this.id = id;
        this.product_No = product_No;
        this.image_url = image_url;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProduct_No() {
        return product_No;
    }

    public void setProduct_No(Integer product_No) {
        this.product_No = product_No;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
