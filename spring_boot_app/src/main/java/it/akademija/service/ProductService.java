package it.akademija.service;

import it.akademija.dao.UserDao;
import it.akademija.dto.ProductDTO;
import it.akademija.entity.ProductEntity;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.CreateUserCommand;
import it.akademija.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(@Qualifier("productrepo")ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<CreateProductCommand> getProducts() {
        List<CreateProductCommand> createUserCommandList = productRepository.findAll()
                .stream()
                .map(productEntity -> new CreateProductCommand(
                        productEntity.getProduct_No(),
                        productEntity.getImage_url(),
                        productEntity.getPrice(),
                        productEntity.getCategory(),
                        productEntity.getBrand(),
                        productEntity.getDescription(),
                        productEntity.getQuantity()))
                .collect(Collectors.toList());

                return createUserCommandList;
    }


    @Transactional
    public CreateProductCommand findProduct(Integer product_No){

        ProductEntity productEntity = productRepository.getProductByNumber(product_No);
        CreateProductCommand createProductCommand = new CreateProductCommand(
                productEntity.getProduct_No(),
                productEntity.getImage_url(),
                productEntity.getPrice(),
                productEntity.getBrand(),
                productEntity.getDescription(),
                productEntity.getCategory(),
                productEntity.getQuantity()
        );
        return createProductCommand;
    }

    @Transactional
    public void createProduct(CreateProductCommand createProductCommand){
                 ProductEntity productEntity = new ProductEntity(

                         new Long((createProductCommand.getProduct_No()  +  11)), //custom id creation
                         createProductCommand.getProduct_No(),
                         createProductCommand.getImage_url(),
                         createProductCommand.getPrice(),
                         createProductCommand.getCategory(),
                         createProductCommand.getBrand(),
                         createProductCommand.getDescription(),
                         new Integer(0),
                         createProductCommand.getQuantity(),
                         true,
                         new Date()
                    );
                 productRepository.save(productEntity);
    }

    public void updateProduct(Integer product_No){
        ProductEntity productEntity = productRepository.getProductByNumber(product_No);
//        ProductEntity productEntity = productRepository.findById(id).orElse(null);
//        Optional<ProductEntity> productEntity = productRepository.findById(id);// use optional arba oerElse(null)
        productRepository.save(productEntity);
    }

    @Transactional
    public void deleProduct(Integer product_No){
        ProductEntity productEntity = productRepository.getProductByNumber(product_No);
        productRepository.delete(productEntity);
    }



}
