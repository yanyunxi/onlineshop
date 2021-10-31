package com.swufestu.onlineshop.model;

public class item {
    Integer id;
    Integer imageurl;
    String name;
    String description;
    String price;
    String quantity;
    String unit;
    int imageUrl;
    int bigimageurl;

    public item(Integer id, Integer imageurl, String name, String price, int imageUrl) {
        this.id = id;
        this.imageurl = imageurl;
        this.name = name;
        this.price = price;
        this.bigimageurl = imageurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public int getBigimageurl() {
        return bigimageurl;
    }

    public void setBigimageurl(int bigimageurl) {
        this.bigimageurl = bigimageurl;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
