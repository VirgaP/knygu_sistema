package it.akademija.service;

import it.akademija.entity.Cart;
import it.akademija.entity.CartProduct;
import it.akademija.entity.ProductEntity;
import it.akademija.entity.User;
import it.akademija.exceptions.ResourceNotFoundException;
import it.akademija.model.RequestCart;
import it.akademija.model.RequestCartProduct;
import it.akademija.repository.CartProductRepository;
import it.akademija.repository.CartRepository;
import it.akademija.repository.DBUserDAO;
import it.akademija.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Set;

@Service
public class CartProductService {

    public final CartRepository cartRepository;
    public final ProductRepository productRepository;
    public final CartProductRepository cartProductRepository;
    Cart cart;
    User user;
    public final DBUserDAO dbUserDAO;

    @Autowired
    public CartProductService(CartRepository cartRepository, ProductRepository productRepository, CartProductRepository cartProductRepository, DBUserDAO dbUserDAO) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartProductRepository = cartProductRepository;
        this.dbUserDAO = dbUserDAO;
    }

    @Transactional
    public void createCartProduct(RequestCartProduct requestCartProduct){

        CartProduct cartProduct = new CartProduct(
                new Long(1)
        );
        cartProduct.setCart(cartRepository.findByUserUsername(requestCartProduct.getUsername()));  //DB: cart_id
        cartProduct.setProductEntity(productRepository.getProductByNumber(requestCartProduct.getProduct_No()));  //DB: product_id
        CartProduct cartProductSaved = cartProductRepository.save(cartProduct);

        Cart cart = cartRepository.findByUserUsername(requestCartProduct.getUsername());
        if(cart == null){
            cart = new Cart();
            cart.setUser(dbUserDAO.getUser(requestCartProduct.getUsername()));
        }
        cart.addProdcut(cartProductSaved);
        cartRepository.save(cart);
    }

    @Transactional
    public void removeProductFromCart(Long id){
        CartProduct cartProduct = cartProductRepository.getOne(id);
        Set<CartProduct> cartProductList = cart.getCartProducts();

        if (!cartProductList.contains(cartProduct)) {
            throw new ResourceNotFoundException("the product is not found");
        } else {
            cart.removeProduct(cartProduct);
        }

    }
}
