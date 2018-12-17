package it.akademija.entity;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//inverse side for cartproduct relation
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cart_id", updatable = false, nullable = false)
    private Long id;

//    @JsonManagedReference or @JsonBackReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true) //Bidirectional @OneToMany
    @Valid
//    private List<CartProduct> cartProducts = new ArrayList<>();
    private Set<CartProduct> cartProducts = new HashSet<>();

    @OneToOne(mappedBy = "cart")
    private User user;

    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;
        this.cartProducts = cartProducts;
        this.user = user;
    }



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

    public void removeProduct(CartProduct cartProduct) {
        cartProducts.remove(cartProduct);
        cartProduct.setCart(null);
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


    @Transient
    public int getNumberOfProducts() {
        return this.cartProducts.size();
    }

    @Transient
    public BigDecimal getTotalOrderPrice() {
        BigDecimal sum = BigDecimal.valueOf(0.00);
        Set<CartProduct> cartProducts = getCartProducts();
        for (CartProduct cp : cartProducts) {
            sum = sum.add(cp.getTotalPrice()) ;
        }
        return sum;
    }
//    BigDecimal totalPrice = productEntity.getPrice().multiply(new BigDecimal(getQuantity()));

}
