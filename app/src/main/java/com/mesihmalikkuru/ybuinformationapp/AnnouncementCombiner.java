package com.mesihmalikkuru.ybuinformationapp;

import java.io.Serializable;

/**
 * Created by mesihmalikkuru on 19/05/2017.
 */

public class AnnouncementCombiner implements Serializable{

    private String name;
    private String address;

    public AnnouncementCombiner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}
