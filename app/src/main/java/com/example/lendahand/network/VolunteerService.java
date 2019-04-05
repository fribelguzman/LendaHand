package com.example.lendahand.network;

import com.example.lendahand.model.VolunteerList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VolunteerService {

    @GET("fribelguzman/419ae7420a7f590d1e80c55731db51f2/raw/53e7359ce3b733138e754d0d7379c7890ba1f3f2/gistfile1.txt")
    Call<VolunteerList> getVolunteer();
}
