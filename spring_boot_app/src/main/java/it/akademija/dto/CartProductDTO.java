package it.akademija.dto;

import it.akademija.entity.CartProduct;
import it.akademija.entity.User;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CartProductDTO {

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private Integer productNo;

    private Long cartProductId;

    public CartProductDTO() {

    }

    public CartProductDTO(String name, BigDecimal price, Integer quantity, Integer productNo, Long cartProductId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productNo = productNo;
        this.cartProductId = cartProductId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }
}
