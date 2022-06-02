package com.midterm.reviewfilmproject;

import java.io.Serializable;

public class film implements Serializable {
    private int id;
    private String name;
    private int year;
    private String desc;

    public film(int id, String name, int year, String desc) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
