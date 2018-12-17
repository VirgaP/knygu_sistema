package it.akademija.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {

    @Id
    private Long id;

    Cart cart;


}
