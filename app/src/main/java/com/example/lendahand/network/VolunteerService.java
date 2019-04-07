package com.example.lendahand.network;

import com.example.lendahand.model.VolunteerList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VolunteerService {

    @GET("fribelguzman/419ae7420a7f590d1e80c55731db51f2/raw/417f6061c940de34f1c90c6087e32fcbd22b7fd3/gistfile1.txt")
    Call<VolunteerList> getVolunteer();
}
