package com.example.lendahand.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lendahand.FragmentInterface;
import com.example.lendahand.R;
import com.example.lendahand.model.Volunteer;
import com.example.lendahand.model.VolunteerList;
import com.example.lendahand.network.RetrofitSingleton;
import com.example.lendahand.network.VolunteerService;
import com.example.lendahand.recycler.VolunteerAdapter;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ItemViewFragment extends Fragment {
    private Retrofit retrofit;
    RecyclerView recyclerView;
    private View rootview;
    private VolunteerAdapter volunteerAdapter;
    private List<Volunteer> volunteers = Collections.emptyList();

    private final static String TAG = ItemViewFragment.class.getSimpleName();

    private FragmentInterface fragmentListener;

    public ItemViewFragment() {
    }


    public static ItemViewFragment newInstance() {
        ItemViewFragment fragment = new ItemViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        } else {
            Log.d(TAG, "onCreate: null");
        }

        retrofit = RetrofitSingleton.getInstance();

        VolunteerService service = retrofit.create(VolunteerService.class);
        Call<VolunteerList> volunteerList = service.getVolunteer();
        volunteerList.enqueue(new Callback<VolunteerList>() {

            @Override
            public void onResponse(Call<VolunteerList> call, Response<VolunteerList> response) {
                Log.d(TAG, "Fribel - " + response.body().toString());
                VolunteerList responseModel = response.body();
                volunteers = responseModel.getVolunteerList();
                Log.d(TAG, "onResponse: List - " + volunteers.size());
                Log.d(TAG, "onResponse: List - " + volunteers.get(0).getUrl());
                volunteerAdapter.setVolunteerList(volunteers);

            }

            @Override
            public void onFailure(Call<VolunteerList> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootview = inflater.inflate(R.layout.recycler_fragment, container, false);

        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = rootview.findViewById(R.id.recycler_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootview.getContext()));
        volunteerAdapter = new VolunteerAdapter(fragmentListener);
        Log.d(TAG, "onViewCreated: " + volunteerAdapter.getItemCount());
        volunteerAdapter.setVolunteerList(volunteers);
        Log.d(TAG, "onViewCreated: List - " + volunteers.size());

        recyclerView.setAdapter(volunteerAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentListener = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

}
