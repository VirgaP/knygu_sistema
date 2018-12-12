package it.akademija.entity;



import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(ProductEntity.class);

    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Id
    @Column
    private Integer product_No;
    @Column
    private String image_url;
    @Column
    private BigDecimal price;
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
    private boolean inStock;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="product_created_at", updatable = false)
    @CreationTimestamp
    private Date dateCreated;


    public ProductEntity(){
    }

    public ProductEntity(Long id, Integer product_No, String image_url, BigDecimal price, String category, String brand, String description, Integer rating, Integer quantity, boolean inStock, Date dateCreated) {
        this.id = id;
        this.product_No=product_No;
        this.image_url = image_url;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.quantity = quantity;
        this.inStock = inStock;
        this.dateCreated = dateCreated;
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

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @PostConstruct
    public void init() {
        LOG.info("ProductEntity PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("ProductEntity PreDestroy");
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", image_url='" + image_url + '\'' + ", price=" + price + ", category='" + category + '\'' + ", brand='" + brand + '\'' + ", description='" + description + '\'' + ", rating=" + rating + ", quantity=" + quantity + ", inStock=" + inStock + ", dateCreated=" + dateCreated + '}';
    }
}
