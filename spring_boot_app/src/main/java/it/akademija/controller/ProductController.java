package it.akademija.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.dao.ProductDao;
import it.akademija.dto.ProductDTO;
import it.akademija.entity.ProductEntity;
import it.akademija.exceptions.ResourceNotFoundException;
import it.akademija.model.CreateProductCommand;
import it.akademija.model.CreateUserCommand;
import it.akademija.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private final ProductService productService;
    private ProductEntity product;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get list of products in databse", notes="Returns list of products from databse")
    @CrossOrigin(origins = "http://localhost:3000")
    List<CreateProductCommand> getAllProducts(Pageable pageable){
        return productService.getProducts();
    }


    @RequestMapping(path = "/{product_No}", method = RequestMethod.GET)
    @ApiOperation(value="Get a product", notes="Returns product users username, name, surname and by product number")
    @CrossOrigin(origins = "http://localhost:3000")
    public ProductDTO getProduct(@PathVariable final Integer product_No){
        return productService.findProduct(product_No);
    }

//    @RequestMapping(value = "/foo", params = { "page", "size" }, method = RequestMethod.GET )
//    @ResponseBody
//    public List<ProductDTO> findPaginated(
//            @RequestParam( "page" ) int page, @RequestParam( "size" ) int size,
//            UriComponentsBuilder uriBuilder, HttpServletResponse response ){
//
//        Page<ProductDTO> resultPage = productService.getPaginatedList(page, size);
//        if( page > resultPage.getTotalPages() ) {
//            throw new ResourceNotFoundException();
//        }
////        eventPublisher.publishEvent( new PaginatedResultsRetrievedEvent< Foo >
////                ( Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size ) );
//
//        return resultPage.getContent();
//    }


    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value="Create product", notes = "Creates product with data from client")
    @ResponseStatus(HttpStatus.CREATED) //productData pasiimti is Client
    void createProduct(
            @ApiParam(value="Product data", required=true)
            @RequestBody final CreateProductCommand cmd){
            productService.createProduct(cmd);
    }

    @RequestMapping(path = "/{product_No}/edit", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value="Get and update product", notes="Returns product by product number and updates")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct  (
            @ApiParam(value="Product data", required=true)
            @RequestBody  CreateProductCommand cmd) throws ResourceNotFoundException {
        productService.updateProductWithException(cmd);

    }

    @RequestMapping(path = "/{product_No}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete product", notes="Deletes product user by product number")
    void deleteProduct(@PathVariable final Integer product_No){
        productService.deleteProduct(product_No);
    }


}
