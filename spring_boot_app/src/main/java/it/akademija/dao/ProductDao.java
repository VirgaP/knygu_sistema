package it.akademija.dao;

import it.akademija.model.Product;

import java.util.List;


public interface ProductDao {

    List<Product> getAllProducts();
    public Product getProduct(Integer id);
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
}
