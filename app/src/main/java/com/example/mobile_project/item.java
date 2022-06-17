package com.example.mobile_project;

public class item {
    String img;
    String name;
    String desc;
    String price;

    public item(String img, String name, String desc, String price) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
