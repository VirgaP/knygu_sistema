package it.akademija.service;

import io.swagger.models.auth.In;
import it.akademija.dao.UserDao;
import it.akademija.dto.ProductDTO;
import it.akademija.entity.Cart;
import it.akademija.entity.CartProduct;
import it.akademija.entity.ProductEntity;
import it.akademija.exceptions.ResourceNotFoundException;
import it.akademija.model.CreateProductCommand;
import it.akademija.repository.CartRepository;
import it.akademija.repository.ProductPaginationRepo;
import it.akademija.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final static int PAGESIZE = 3;

    private ProductRepository productRepository;

    @Autowired
    private ProductPaginationRepo paginationRepo;

    @Autowired
    private CartRepository cartRepository;

    //jei reikes sukurti productlist new ProductEntity cia

    @Autowired
    public ProductService(@Qualifier("productrepo")ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public List<CreateProductCommand> getProducts() {
        long count = productRepository.count();
        int pageSize = 3;
        long pages = count / pageSize;
        List<CreateProductCommand> list = new ArrayList<>();
        for (int i = 0; i < pages; i++){

        list = productRepository
                .findAll(PageRequest.of(i, pageSize, Sort.by("dateCreated").descending()))
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
        }
        return list;
    }

    @Transactional
    public ProductDTO findProduct(Integer product_No){
        ProductEntity productEntity = productRepository.getProductByNumber(product_No);
        ProductDTO productDTO= new ProductDTO(
                productEntity.getProduct_No(),
                productEntity.getImage_url(),
                productEntity.getPrice(),
                productEntity.getBrand(),
                productEntity.getDescription(),
                productEntity.getCategory(),
                productEntity.getRating()
        );
        return productDTO;
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
                         new Integer(1),
                         createProductCommand.getQuantity(),
                         createProductCommand.getQuantity() > 0 ? true : false,
                         new Date()
                    );
                 productRepository.save(productEntity);
    }

    @Transactional
    public void updateProductWithException(CreateProductCommand cmd) throws ResourceNotFoundException{

//        productRepository.findAll().stream().filter(productEntity -> productEntity.getProduct_No().equals(product_No)).findFirst().get();

        ProductEntity productEntity = productRepository.getProductByNumber(cmd.getProduct_No());
                productEntity.setProduct_No(cmd.getProduct_No());
                productEntity.setImage_url(cmd.getImage_url());
                productEntity.setPrice(cmd.getPrice());
                productEntity.setBrand(cmd.getBrand());
                productEntity.setDescription(cmd.getDescription());
                productEntity.setCategory(cmd.getCategory());

            productRepository.save(productEntity);

    }

    @Transactional
    public void deleteProduct(Integer product_No){
        ProductEntity productEntity = productRepository.getProductByNumber(product_No);
        productRepository.delete(productEntity);
    }

}
