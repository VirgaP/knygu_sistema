package it.akademija.dto;

import it.akademija.entity.CartProduct;
import it.akademija.entity.User;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CartDTO {


    private Set<CartProduct> cartProducts;

    private User user;

    public CartDTO() {
    }

    public CartDTO(Set<CartProduct> cartProducts) {

        this.cartProducts = cartProducts;
    }


    public Set<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(Set<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
