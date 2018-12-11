package it.akademija.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.math.BigDecimal;

//@Resource(name = "product")
//@Data
//@AllArgsConstructor
public class Product {

    private static final Logger LOG = LoggerFactory.getLogger(Product.class);
    private Integer id;
    private String image_url;
    private Double price;
    private String category;
    private String brand;
    private String description;
    private Integer rating;
    private Integer quantity;
    private Boolean inStock;

    public Product(Integer id, String image_url, Double price, String category, String brand, String description, Integer rating, Integer quantity, Boolean inStock) {
        this.id = id;
        this.image_url = image_url;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @PostConstruct
    public void init() {
        LOG.info("Product PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("Product PreDestroy");
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", image_url='" + image_url + '\'' + ", price=" + price + ", category='" + category + '\'' + ", brand='" + brand + '\'' + ", description='" + description + '\'' + ", rating=" + rating + ", quantity=" + quantity + ", inStock=" + inStock + '}';
    }
}
