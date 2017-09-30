package com.example.hamza.madassignment1;

/**
 * Created by Hamza on 9/30/2017.
 */
public class Contact {
    private String name, number;
    private int image;
    private String call;

    public Contact() {
    }

    public Contact(String name, String number, int image, String call) {
        this.name = name;
        this.number = number;
        // this.year = year;
        this.image = image;
        this.call = call;
    }

    public String getName() {
        return name;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getCall() {
        return call;
    }

    public void setName(String name) {
        this.name = name;
    }
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}