package com.example.als.myanime;

public class Anime {
    private String name;
    private String description;
    private String rating;
    private int episode;
    private String image;
    private String categorie;
    private String studio;

    public Anime(String name, String description, String rating, int episode, String image, String categorie, String studio) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episode = episode;
        this.image = image;
        this.categorie = categorie;
        this.studio = studio;
    }

    public Anime() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}