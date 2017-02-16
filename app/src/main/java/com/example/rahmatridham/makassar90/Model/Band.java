package com.example.rahmatridham.makassar90.Model;

/**
 * Created by rahmatridham on 2/9/2017.
 */

public class Band {
    String name, desc, img_url;

    public Band(String name, String desc, String img_url) {
        this.name = name;
        this.desc = desc;
        this.img_url = img_url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

}
