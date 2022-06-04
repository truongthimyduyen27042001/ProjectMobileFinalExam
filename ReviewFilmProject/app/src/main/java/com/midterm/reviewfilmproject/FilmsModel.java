package com.midterm.reviewfilmproject;

import java.io.Serializable;

public class FilmsModel implements Serializable {
    String name;
    String img_url;
    String type;
    String desc;
    String year;
    String video_url;

    public FilmsModel() {
    }




    public FilmsModel(String name, String img_url, String type, String desc, String year, String video_url) {
        this.name = name;
        this.img_url = img_url;
        this.type = type;
        this.desc = desc;
        this.year = year;
        this.video_url = video_url;
    }
    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
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