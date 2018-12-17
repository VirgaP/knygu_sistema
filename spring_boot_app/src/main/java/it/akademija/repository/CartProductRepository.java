package it.akademija.repository;

import it.akademija.entity.Cart;
import it.akademija.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    Set<CartProduct> findAllByCartId(Cart id);


}
