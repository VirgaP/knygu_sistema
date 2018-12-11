package it.akademija.controller;

import it.akademija.dao.ProductDao;
import it.akademija.dao.UserDao;
import it.akademija.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public Product getProduct(@PathVariable final Integer id){
        return productDao.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED) //productData pasiimti is Client
    void createProduct(Product product){
        productDao.createProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    void updateProduct(Product product){
        productDao.updateProduct(product);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(Integer id){
        productDao.deleteProduct(id);
    }
}
