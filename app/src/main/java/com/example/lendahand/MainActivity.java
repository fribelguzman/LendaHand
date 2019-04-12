package com.example.lendahand;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabWidget;

import com.example.lendahand.fragments.CalendarFragment;
import com.example.lendahand.fragments.DisplayFragment;
import com.example.lendahand.fragments.ItemViewFragment;
import com.example.lendahand.fragments.LikeFragment;
import com.example.lendahand.model.Volunteer;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    private Retrofit retrofit;
    private TabLayout tabLayout;
    private final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment;
        fragment = new ItemViewFragment();
        navigateTo(fragment);

        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                Fragment fragment;
                switch (pos) {
                    case 0:
                        fragment = new ItemViewFragment();
                        navigateTo(fragment);
                        break;

                    case 1:
                        fragment = new LikeFragment();
                        navigateTo(fragment);
                        break;

                    case 2:
                        fragment = new CalendarFragment();
                        navigateTo(fragment);
                        break;

                    default:


                }
                Log.d(MainActivity.class.getSimpleName(), "position" + tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getPosition();
            }
        });
    }
    @Override
    public void showItemViewFragment(Volunteer volunteer) {
        Fragment fragment;
        fragment = new ItemViewFragment();
        navigateTo(fragment);
    }
    @Override
    public void showDisplayFragment(Volunteer volunteer) {
        Fragment fragment;
        fragment = new DisplayFragment();
        navigateTo(fragment);
    }

    @Override
    public void showLikeFragment(Volunteer volunteer) {
        Fragment fragment;
        fragment = new LikeFragment();
        navigateTo(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.git:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                Uri.parse("https://github.com/fribelguzman");
                startActivity(browserIntent);
                return true;
            case R.id.linked:
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW);
                Uri.parse("www.linkedin.com/in/fribel-guzman");
                startActivity(browserIntent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void navigateTo(Fragment fragment) {
        Log.d(TAG, "navigateTo: " + fragment.getClass().getSimpleName());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }
}