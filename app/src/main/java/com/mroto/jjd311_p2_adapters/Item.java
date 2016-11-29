package com.mroto.jjd311_p2_adapters;

public class Item {
    private String title;
    private String body;
    private String imageRef;

    public Item(String imgRef, String title, String body) {
        this.body = body;
        this.title = title;
        this.imageRef = imgRef;
    }

    //GETTERS:
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getImageRef() {
        return imageRef;
    }


    //@Override
    //public String toString(){
    //   return this.title+": "+this.body;
    //}
}
