package it.akademija.entity;

import javax.persistence.*;

//Owning side
@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cart_product_id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private ProductEntity productEntity;

    private Integer quantity;

    public CartProduct() {
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
}

