package edu.unbosque.JPATutorial.servlets.pojos;

public class AuthorPOJO {

    private Integer authorId;

    private String name;

    public AuthorPOJO() { }

    public AuthorPOJO(Integer authorId, String name) {
        this.authorId = authorId;
        this.name = name;
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

}
