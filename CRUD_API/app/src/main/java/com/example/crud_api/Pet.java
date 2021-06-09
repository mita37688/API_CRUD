package com.example.crud_api;

public class Pet {
    private int id;
    private String petName;
    private String category;
    private Boolean sex;
    private int height;
    private int weight;
    private int imgPet;

    public Pet(int id, String petName, String category, Boolean sex, int height, int weight, int imgPet) {
        this.id = id;
        this.petName = petName;
        this.category = category;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.imgPet = imgPet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getImgPet() {
        return imgPet;
    }

    public void setImgPet(int imgPet) {
        this.imgPet = imgPet;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", category='" + category + '\'' +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                ", imgPet=" + imgPet +
                '}';
    }
}
