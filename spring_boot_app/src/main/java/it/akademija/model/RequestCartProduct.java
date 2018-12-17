package it.akademija.model;

import it.akademija.entity.Cart;
import it.akademija.entity.ProductEntity;

public class RequestCartProduct {

    String username;

    Integer product_No;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProduct_No() {
        return product_No;
    }

    public void setProduct_No(Integer product_No) {
        this.product_No = product_No;
    }

    //    changed to match params from Recat addtocart button
//
//    private Cart cart;
//
//    private ProductEntity productEntity;
//
//
//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }
//
//    public ProductEntity getProductEntity() {
//        return productEntity;
//    }
//
//    public void setProductEntity(ProductEntity productEntity) {
//        this.productEntity = productEntity;
//    }

}
