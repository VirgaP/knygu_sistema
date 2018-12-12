package it.akademija.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.dao.ProductDao;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.CreateUserCommand;
import it.akademija.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get list of products in databse", notes="Returns list of products from databse")
    @CrossOrigin(origins = "http://localhost:3000")
    List<CreateProductCommand> getAllProducts(){
        return productService.getProducts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get a product", notes="Returns product users username, name, surname and by product number")
    @CrossOrigin(origins = "http://localhost:3000")
    public CreateProductCommand getProduct(@PathVariable final Integer product_No){
        return productService.findProduct(product_No);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value="Create product", notes = "Creates product with data from client")
    @ResponseStatus(HttpStatus.CREATED) //productData pasiimti is Client
    void createProduct(
            @ApiParam(value="Product data", required=true)
            @RequestBody final CreateProductCommand cmd){
            productService.createProduct(cmd);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value="Get and update product", notes="Returns product by product number and updates")
    @ResponseStatus(HttpStatus.OK)
    void updateProduct(
            @ApiParam(value="Product data", required=true)
            @RequestBody final CreateProductCommand cmd){
        productService.updateProduct(cmd.getProduct_No());
    }

    @RequestMapping(path = "/{product_No}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete product", notes="Deletes product user by product number")
    void deleteProduct(@PathVariable final Integer product_No){
        productService.deleProduct(product_No);
    }


}
