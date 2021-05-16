package com.example.rahabulislam.bachau;

public class Work_Data {

    private String w_name, catagory, contact, place, post;

    public Work_Data()
    {

    }

    public Work_Data(String w_name, String catagory, String contact, String place, String post) {
        this.w_name = w_name;
        this.catagory = catagory;
        this.contact = contact;
        this.place = place;
        this.post = post;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
