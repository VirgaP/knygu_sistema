package it.akademija.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

//Owning side with cart, contains join column ref. Cat product is a child entity?
// "savininkas", todėl kiekvieną kartą pridedant naują prekę į krepšelį, turi būti susiejamas krepšelis, kviečiant savininko susiejimo metodą setCart().
@Entity
public class CartProduct implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cart_product_id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", updatable = false)
    private Cart cart;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private ProductEntity productEntity;

    @Transient
    private Integer quantity;

    @Transient
    private BigDecimal totalPrice;

    public CartProduct() {
    }

    public CartProduct(Long id) {
        this.id = id;
        this.setCart(cart);
        this.setProductEntity(productEntity);

    }

    public CartProduct(Long id, Cart cart, ProductEntity productEntity, Integer quantity) {
        this.id = id;
        this.cart = cart;
        this.productEntity = productEntity;
        this.quantity = quantity;
        setCart(cart);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartProduct )) return false;
        return id != null && id.equals(((CartProduct) o).id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BigDecimal getTotalPrice() {


        BigDecimal totalPrice = productEntity.getPrice().multiply(new BigDecimal(getQuantity()));
        return totalPrice;
    }


}

//The child entity, CartProduct, implement the equals and hashCode methods. Since we cannot rely on a natural identifier for equality checks, we need to use the entity identifier instead. However, you need to do it properly so that equality is consistent across all entity state transitions. Because we rely on equality for the removeComment, it’s good practice to override equals and hashCode for the child entity in a bidirectional association.

