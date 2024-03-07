package ru.yandex.order;

import java.util.List;

public class OrderModel {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private String rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> colour;

    public OrderModel() {
    }

    public OrderModel(List<String> colour) {
        this.firstName = "Chuck";
        this.lastName = "Norris";
        this.address = "LowKick str., 69";
        this.metroStation = "ChuckStation";
        this.phone = "+1696661315";
        this.rentTime = "7";
        this.deliveryDate = "2023-03-23";
        this.comment = "Chuck Norris writes code that optimizes itself.";
        this.colour = colour;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMetroStation() {
        return metroStation;
    }
    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRentTime() {
        return rentTime;
    }
    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }
    public String getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public List<String> getColour() {
        return colour;
    }
    public void setColour(List<String> colour) {
        this.colour = colour;
    }
}
