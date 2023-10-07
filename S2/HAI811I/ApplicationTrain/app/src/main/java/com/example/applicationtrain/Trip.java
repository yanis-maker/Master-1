package com.example.applicationtrain;

public class Trip {

    private String  start;
    private String finish;
    private String hStart;
    private String hFinish;
    private String price;

    public Trip(String start, String finish, String hStart, String hFinish, String price) {
        this.start = start;
        this.finish = finish;
        this.hStart = hStart;
        this.hFinish = hFinish;
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String gethStart() {
        return hStart;
    }

    public void sethStart(String hStart) {
        this.hStart = hStart;
    }

    public String gethFinish() {
        return hFinish;
    }

    public void sethFinish(String hFinish) {
        this.hFinish = hFinish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
