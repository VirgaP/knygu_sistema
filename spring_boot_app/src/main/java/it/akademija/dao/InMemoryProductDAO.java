package it.akademija.dao;

import it.akademija.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryProductDAO implements ProductDao {

    List<Product> products;

    public InMemoryProductDAO() {
        products = new ArrayList<Product>();
        Product product1 = new Product(1, "http://placehold.it/700x400", 120.50, "city bike", "Grant", "lorem ipsum", 4, 23, true );

        Product product2 = new Product(2, "http://placehold.it/700x400", 1000.00, "racing bike", "Specialized", "lorem ipsum", 5, 4, true );

        Product product3 = new Product(3, "http://placehold.it/700x400", 10.80, "bike parts", "XXsport", "lorem ipsum", 4, 8, true );

        Product product4 = new Product(4, "http://placehold.it/700x400", 1500.00, "racing bike", "Italian", "lorem ipsum", 5, 1, true);

        Product product5 = new Product(5, "http://placehold.it/700x400", 4.50, "bike parts", "tuberrr", "lorem ipsum", 3, 49, true);

        Product product6 = new Product(6, "http://placehold.it/700x400", 254.50, "city bike", "gandras", "lorem ipsum", 5, 10, true);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);

    }


    @Override
    public List<Product> getAllProducts() {
        System.out.println(products);
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product getProduct(Integer id) {
        Product result = products.stream()
                .filter((pr) -> id.equals(pr.getId()) && true == pr.getInStock())
                .findAny()
                .orElse(null);

        return result;
    }

    @Override
    public void createProduct(Product product) {
            products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        products.get(product.getId()).setDescription(product.getDescription());
    }

    @Override
    public void deleteProduct(Integer id) {
        for (Product product: products) {
            if (id.equals(product.getId())) {
                products.remove(product);
                break; }
        }

        //arba products.remove(product.getId()); //arg: Product product
    }
}
