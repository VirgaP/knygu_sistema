package it.akademija.model;

import it.akademija.entity.CartProduct;
import it.akademija.entity.User;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestCart {


   private String username;

    private Long id;

    private User user;

//    private Set<RequestCartProduct> cartProducts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Set<CartProduct> getCartProducts() {
//        return cartProducts;
//    }
//
//    public void setCartProducts(Set<CartProduct> cartProducts) {
//        this.cartProducts = cartProducts;
//    }
}
