package it.akademija.entity;


import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
    private String image_url;
    @Column
    private Double price;
    @Column
    private String category;
    @Column
    private String brand;
    @Column
    private String description;
    @Column
    private Integer rating;
    @Column
    private Integer quantity;
    @Column
    private Boolean inStock;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public ProductEntity(){
    }

    public ProductEntity(Integer id, String image_url, Double price, String category, String brand, String description, Integer rating, Integer quantity, Boolean inStock, Date date) {
        this.id = id;
        this.image_url = image_url;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.quantity = quantity;
        this.inStock = inStock;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
