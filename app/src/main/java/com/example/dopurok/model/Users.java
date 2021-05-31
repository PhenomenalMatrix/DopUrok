package com.example.dopurok.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String fio;
    private int image;

    public Users() {}

    public Users(String name, String fio, int image) {
        this.name = name;
        this.fio = fio;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
