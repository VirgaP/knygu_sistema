package it.akademija.model;

import it.akademija.entity.Institution;

import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class RequestBook {

    private String title;

    private String author;

    private Integer pageCount;

    private String image;

    private Set<Institution> institutions;

    public RequestBook(String title, String author, Integer pageCount, String image) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.image = image;
    }

    public RequestBook() {
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


}
