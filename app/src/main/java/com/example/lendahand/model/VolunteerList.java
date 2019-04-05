package com.example.lendahand.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolunteerList {

    @SerializedName("Volunteer")
    List<Volunteer>  volunteerList;

    public List<Volunteer> getVolunteerList() {
        return volunteerList;
    }

    public VolunteerList(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }
}
