package edu.unbosque.JPATutorial.servlets.pojos;

public class AuthorPOJO {

    private Integer authorId;

    private String name;

    private Integer numBooks;

    public AuthorPOJO() { }

    public AuthorPOJO(Integer authorId, String name, Integer numBooks) {
        this.authorId = authorId;
        this.name = name;
        this.numBooks = numBooks;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

}
