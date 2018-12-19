package it.akademija.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Owning side

@Entity
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "books_institutions",
            joinColumns = { @JoinColumn(name = "fk_book") },
            inverseJoinColumns = { @JoinColumn(name = "fk_institution") })

    private Set<Institution> institutions = new HashSet<>();

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private Integer pageCount;

    @Column
    private String image;

//    private BigDecimal price;
//
//    private Integer quantity;
//
//    private String status;


    public Book(Long id, String title, String author, Integer pageCount, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.image = image;
    }

    public Book() {
    }


    public void addInstitution(Institution inst) {
        this.institutions.add(inst);
        inst.getBookSet().add(this);
    }

    public void removeInstitution(Institution inst) {
        this.institutions.remove(inst);
        inst.getBookSet().remove(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Set<Institution> institutions) {
        this.institutions = institutions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
