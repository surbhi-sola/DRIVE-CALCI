package com.tanay.drivecalci;

public class Calculator {
    private double w;
    private double r;
    private double voltage;
    private double capacity;
    private double cd;
    private double A;
    private double rr;
    private double inclination;



    public void setVehicleData(double weight, double radius, double volt, double capa, double cod, double area, double roll, double inclina){
            w=weight;
            r=radius;
            voltage= volt;
            capacity= capa;
            A= area;
            rr=roll;
            cd= cod;
            inclination= inclina;
    }

    public double getA() {
        return A;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCd() {
        return cd;
    }

    public double getRr() {
        return rr;
    }

    public double getInclination() {
        return inclination;
    }

    public double getR() {
        return r;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getW() {
        return w;
    }
}
