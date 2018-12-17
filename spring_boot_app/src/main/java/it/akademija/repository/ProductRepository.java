package it.akademija.repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import it.akademija.dao.ProductDao;
import it.akademija.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
@Qualifier("productrepo")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
        @Modifying
        @Query("update ProductEntity p set p.inStock = true where p.quantity < 1")
        void deleteIfNotInStock(Boolean inStock);
        @Query("select p from ProductEntity p where p.product_No = ?1")
        ProductEntity getProductByNumber(Integer product_No);

        List<ProductEntity> findByDateCreated(Date dateCreated, Pageable pageable);

}
