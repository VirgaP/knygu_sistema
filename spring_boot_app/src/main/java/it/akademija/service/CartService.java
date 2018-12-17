package it.akademija.service;

import it.akademija.dto.CartProductDTO;
import it.akademija.entity.Cart;
import it.akademija.entity.CartProduct;
import it.akademija.exceptions.ResourceNotFoundException;
import it.akademija.model.RequestCart;
import it.akademija.repository.CartProductRepository;
import it.akademija.repository.CartRepository;
import it.akademija.repository.DBUserDAO;
import it.akademija.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private CartProductRepository cartProductRepository;
    private final DBUserDAO dbUserDAO;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartProductRepository cartProductRepository, DBUserDAO dbUserDAO) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartProductRepository = cartProductRepository;
        this.dbUserDAO = dbUserDAO;
    }

    @Transactional
    public void createCart(RequestCart requestCart){
        Cart cart = new Cart (
                   new Long(1)
                );
        cart.setUser(dbUserDAO.getUser(requestCart.getUsername()));
        cartRepository.save(cart);
    }

    @Transactional
    public Cart getCart(Long id) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return cart;
    }

    @Transactional
    public Set<CartProductDTO> getProductsFromCart(String username){
//        Set<CartProduct> cartProducts = cartRepository.findByUserUsername(username).getCartProducts().stream().collect(Collectors.toSet());
//        return cartProducts;

       return dbUserDAO.getUser(username).getCart().getCartProducts()
                .stream()
                .map(item -> new CartProductDTO(
                        item.getProductEntity().getBrand(),
                        item.getProductEntity().getPrice(),
                        item.getQuantity(),
                        item.getProductEntity().getProduct_No(),
                        item.getId()
                ))
                .collect(Collectors.toSet());
    }

    @Transactional
    public void cartCheckout(Long id, List<CartProduct> cartProductList){
            Cart cart = cartRepository.findById(id).orElse(null);
            cartProductRepository.findAllByCartId(cart);
    }


}

