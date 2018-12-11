package it.akademija;

import it.akademija.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestServisas {

//    @Autowired
//    List<Product> products;
//
////    @RequestMapping("/productsCollection")
////    public String getProductsCollection(){
////        String allProducts = products.toString();
////
////        return allProducts;
////    }
//    @RequestMapping("/productsCollection")
//    public List<Product> getProductsCollection(){
//        return products
//                .stream()
//                .collect(Collectors.toList());
//    }
}
