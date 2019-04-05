package com.example.lendahand;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lendahand.fragments.DisplayFragment;
import com.example.lendahand.fragments.ItemViewFragment;
import com.example.lendahand.model.Volunteer;
import com.example.lendahand.model.VolunteerList;
import com.example.lendahand.network.RetrofitSingleton;
import com.example.lendahand.network.VolunteerService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemViewFragment inputFragment = ItemViewFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, inputFragment)
                .addToBackStack(null)
                .commit();

    }



    @Override
    public void showDisplayFragment() {

        getSupportFragmentManager().beginTransaction()
               .replace(R.id.container, DisplayFragment.newInstance())
              .addToBackStack(null)
             .commit();
    }

    }

