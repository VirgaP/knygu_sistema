package it.akademija.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cart_id", updatable = false, nullable = false)
    private Long id;
    @OneToMany(mappedBy = "cart")
    List<CartProduct> cartProducts;

    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addProdcut(CartProduct cartProduct){
        this.cartProducts.add(cartProduct);
        cartProduct.setCart(this);
    }
}
