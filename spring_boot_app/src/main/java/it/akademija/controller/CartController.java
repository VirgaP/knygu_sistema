package it.akademija.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.dto.CartProductDTO;
import it.akademija.model.RequestCart;
import it.akademija.model.RequestCartProduct;
import it.akademija.repository.CartRepository;
import it.akademija.repository.ProductRepository;
import it.akademija.service.CartProductService;
import it.akademija.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/cart")
public class CartController {

    private final CartService cartService;
    private final CartProductService cartProductService;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartController(CartService cartService, CartProductService cartProductService, ProductRepository productRepository, CartRepository cartRepository) {
        this.cartService = cartService;
        this.cartProductService = cartProductService;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value = "Create cart", notes = "Creates cart with data from client")
    @ResponseStatus(HttpStatus.CREATED)
        //productData pasiimti is React, username
    void createCart(@ApiParam(value = "Cart data, username", required = true)
                    @RequestBody final RequestCart requestCart)
    {
        cartService.createCart(requestCart);
    }


//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    @ApiOperation(value = "Get cart", notes = "Returns cart by cart id")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public Cart getCart(@PathVariable final Long id) {
//        return cartService.getCart(id);
//    }


    @RequestMapping(path = "/add/product/", method = RequestMethod.POST)
    @ApiOperation(value = "Add product to cart", notes = "Add product to cart")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addProductToCart(@RequestBody RequestCartProduct requestCartProduct) {
        System.out.println(requestCartProduct.getProduct_No());
        cartProductService.createCartProduct(requestCartProduct);
    }


    @RequestMapping(path = "/{username}/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Remove product", notes="Removes product from cart")
    public void removeProductFromCart(@PathVariable final Long id){
        cartProductService.removeProductFromCart(id);
    }

    @RequestMapping(path= "/{username}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Get all products in cart", notes="Returns list of carts")
    @CrossOrigin(origins = "http://localhost:3000")
    Set<CartProductDTO> getCartProducts(
            @PathVariable final String username
            ){
        return cartService.getProductsFromCart(username);
    }
//
//    @RequestMapping(path = "/{product_No}", method = RequestMethod.POST)
//    @CrossOrigin(origins = "http://localhost:3000")
//    @ApiOperation(value="Add product to cart", notes="Add selected product to cart")
//    public Cart addProductToCart(@PathVariable final Integer product_No) {
//        productRepository.getProductByNumber(product_No).ifPresent(shoppingCartService::addProduct);
//        return cartService.getCartByUser();
//    }

}


