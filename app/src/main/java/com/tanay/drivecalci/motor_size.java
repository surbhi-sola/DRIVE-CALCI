package com.tanay.drivecalci;

public class motor_size {
    private String rating;
    private String size;
    private String weight;
    private String motorVoltage;

    public motor_size(String Rating, String Size, String Weight, String volt ){
        rating=Rating;
        size=Size;
        weight=Weight;
        motorVoltage= volt;
    }

    public String getMotorVoltage() {
        return motorVoltage;
    }

    public String getRating() {
        return rating;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }
}
