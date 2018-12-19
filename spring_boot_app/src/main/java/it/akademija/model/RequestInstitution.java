package it.akademija.model;

import it.akademija.entity.Book;
import it.akademija.enums.InstitutionCategory;
import it.akademija.enums.InstitutionType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.HashSet;
import java.util.Set;

public final class RequestInstitution {

    private String title;

    private String city;

    private String image;

//    private InstitutionCategory category;
//
//    private InstitutionType type;

    private String category;

    private String type;

    private String subtype;

    private Set<Book> bookSet;

    public RequestInstitution() {
    }

    public RequestInstitution(String title, String city, String image, String category, String type, String subtype) {
        this.title = title;
        this.city = city;
        this.image = image;
//        this.category = category;
//        this.type = type;
        this.subtype = subtype;
//        this.bookSet = bookSet;
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
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
