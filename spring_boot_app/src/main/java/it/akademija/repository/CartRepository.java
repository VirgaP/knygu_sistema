package it.akademija.repository;

import it.akademija.entity.Cart;
import it.akademija.entity.CartProduct;
import it.akademija.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long> {
    Cart findByUserUsername(String username);

}
