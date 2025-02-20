package com.training.jsondata.practiceproblems.convertjavaobjectforcartojsonfile;

public class Car {
    private String type;
    private long price;
    private String brand;

    public Car(String type, long price, String brand) {
        this.type = type;
        this.price = price;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}