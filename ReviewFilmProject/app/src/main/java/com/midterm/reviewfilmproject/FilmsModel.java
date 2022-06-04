package com.midterm.reviewfilmproject;

import java.io.Serializable;

public class FilmsModel implements Serializable {
    String name;
    String img_url;
    String type;
    String desc;
    String year;
    String video;
    Boolean istrending;

    public FilmsModel() {
    }

    public FilmsModel(String name, String img_url, String type, String desc, String year, String video, Boolean istrending) {
        this.name = name;
        this.img_url = img_url;
        this.type = type;
        this.desc = desc;
        this.year = year;
        this.video = video;
        this.istrending = istrending;
    }

    public Boolean getIstrending() {
        return istrending;
    }

    public void setIstrending(Boolean istrending) {
        this.istrending = istrending;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}