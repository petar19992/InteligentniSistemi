package com.example.petar.inteligentnisistemi.models;

import java.lang.*;

/**
 * Created by Miloš on 18/01/2017.
 */
public class NavigationObject {

    Car carPosition;
    java.lang.Object desiredObject;

    public Car getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(Car carPosition) {
        this.carPosition = carPosition;
    }

    public java.lang.Object getDesiredObject() {
        return desiredObject;
    }

    public void setDesiredObject(java.lang.Object desiredObject) {
        this.desiredObject = desiredObject;
    }

    @Override
    public String toString() {
        return "NavigationObject{" +
                "carPosition=" + carPosition +
                ", desiredObject=" + desiredObject +
                '}';
    }
}
