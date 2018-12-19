package it.akademija.entity;

import it.akademija.enums.InstitutionCategory;
import it.akademija.enums.InstitutionType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Institution implements Serializable  {

    @Id
    @Column(name="institution_id", updatable = false, nullable = false)
    private String id;

    @NaturalId
    @Column
    private String title;

    @Column
    private String city;

    @Column
    private String image;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 6)
//    private InstitutionCategory category;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 9)
//    private InstitutionType type;

    private String category;

    private String type;

    private String subtype;

    @ManyToMany(mappedBy="institutions", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY) //maybe change to EAGER
    private Set<Book> books = new HashSet<Book>();


    public Institution() {
    }

    public Institution(String id, String title, String city, String image, String category, String type, String subtype) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.image = image;
        this.category = category;
        this.type = type;
        this.subtype = subtype;

    }


    public void addBook(Book b) {
        this.books.add(b);
        b.getInstitutions().add(this);
    }

    public void removeBook(Book b) {
        this.books.remove(b);
        b.getInstitutions().remove(this);
    }


    @PreRemove
    private void removeInstitutionFromBooks() {
        for (Book b : books) {
            b.getInstitutions().remove(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subtype;
    }

    public void setSubType(String subType) {
        this.subtype = subType;
    }

    public Set<Book> getBookSet() {
        return books;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.books = bookSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution institution = (Institution) o;
        return Objects.equals(title, institution.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
