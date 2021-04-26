package edu.unbosque.JPATutorial.servlets.pojos;

public class LibraryPOJO {

    private Integer libraryId;

    private String name;

    public LibraryPOJO() { }

    public LibraryPOJO(Integer libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
