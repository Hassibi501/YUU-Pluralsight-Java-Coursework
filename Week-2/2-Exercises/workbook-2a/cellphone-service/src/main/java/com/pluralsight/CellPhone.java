package com.pluralsight;

public class CellPhone {
    int serialNumber;
    String model;
    String carrier;
    String phoneNumber;
    String ownersName;

    public CellPhone() {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.ownersName = "";
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public String getModel() {
        return this.model;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getOwnersName() {
        return this.ownersName;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public void dial(String phoneNumber) {
        System.out.println(this.ownersName + "'s phone is calling " + phoneNumber);
    }
}
