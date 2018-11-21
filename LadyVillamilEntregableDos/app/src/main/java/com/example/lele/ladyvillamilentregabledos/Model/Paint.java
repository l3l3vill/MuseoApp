package com.example.lele.ladyvillamilentregabledos.Model;

public class Paint {

    //ATRIBUTOS
    private String image;
    private String name;
    private Integer artistId;

    //CONSTRUCTOR
    public Paint(String image, String name, Integer artistId) {
        this.image = image;
        this.name = name;
        this.artistId = artistId;
    }

    //GETTER

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Paint{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                '}';
    }

    //SETTER


    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}
