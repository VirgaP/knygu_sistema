package it.akademija.dao;

import it.akademija.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryProductDAO implements ProductDao {

//    List<ProductDTO> productDTOS;
//
//    public InMemoryProductDAO() {
//        productDTOS = new ArrayList<ProductDTO>();
//        ProductDTO productDTO1 = new ProductDTO(1, "http://placehold.it/700x400", 120.50, "city bike", "Grant", "lorem ipsum", 4, 23, true );
//
//        ProductDTO productDTO2 = new ProductDTO(2, "http://placehold.it/700x400", 1000.00, "racing bike", "Specialized", "lorem ipsum", 5, 4, true );
//
//        ProductDTO productDTO3 = new ProductDTO(3, "http://placehold.it/700x400", 10.80, "bike parts", "XXsport", "lorem ipsum", 4, 8, true );
//
//        ProductDTO productDTO4 = new ProductDTO(4, "http://placehold.it/700x400", 1500.00, "racing bike", "Italian", "lorem ipsum", 5, 1, true);
//
//        ProductDTO productDTO5 = new ProductDTO(5, "http://placehold.it/700x400", 4.50, "bike parts", "tuberrr", "lorem ipsum", 3, 49, true);
//
//        ProductDTO productDTO6 = new ProductDTO(6, "http://placehold.it/700x400", 254.50, "city bike", "gandras", "lorem ipsum", 5, 10, true);
//
//        productDTOS.add(productDTO1);
//        productDTOS.add(productDTO2);
//        productDTOS.add(productDTO3);
//        productDTOS.add(productDTO4);
//        productDTOS.add(productDTO5);
//        productDTOS.add(productDTO6);
//
//    }
//
//
//    @Override
//    public List<ProductDTO> getAllProducts() {
//        System.out.println(productDTOS);
//        return Collections.unmodifiableList(productDTOS);
//    }
//
//    @Override
//    public ProductDTO getProduct(Integer id) {
//        ProductDTO result = productDTOS.stream()
//                .filter((pr) -> id.equals(pr.getId()) && true == pr.getInStock())
//                .findAny()
//                .orElse(null);
//
//        return result;
//    }
//
//    @Override
//    public void createProduct(ProductDTO productDTO) {
//            productDTOS.add(productDTO);
//    }
//
//    @Override
//    public void updateProduct(ProductDTO productDTO) {
//        productDTOS.get(productDTO.getId()).setDescription(productDTO.getDescription());
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        for (ProductDTO productDTO : productDTOS) {
//            if (id.equals(productDTO.getId())) {
//                productDTOS.remove(productDTO);
//                break; }
//        }
//
//        //arba productDTOS.remove(product.getId()); //arg: ProductDTO product
//    }
}
