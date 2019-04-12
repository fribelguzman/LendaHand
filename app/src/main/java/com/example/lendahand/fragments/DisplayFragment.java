package com.example.lendahand.fragments;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lendahand.FragmentInterface;
import com.example.lendahand.R;
import com.example.lendahand.model.Volunteer;
import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

public class DisplayFragment extends Fragment {
    private View rootview;

    private TextView org2;
    private ImageView image;
    private TextView mission;
    private TextView location;
    private Button signup;

    private ToggleButton like;
    private static final String PRIMARY_CHANNEL_ID = "likes";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;
    private SharedPreferences sharedPrefs;

    private static final String ARG_ORG = "org";
    private static final String ARG_MISSION = "mission";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_SIGNUP = "url";

    private String org1;
    private String mission1;
    private String image1;
    private String location1;
    private String signup1;

    private Volunteer volunteer;


    private FragmentInterface mListener;

    public DisplayFragment() {

    }


    public static DisplayFragment newInstance(Volunteer volunteer) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MISSION, volunteer.getMission());
        args.putString(ARG_ORG, volunteer.getOrginization());
        args.putString(ARG_IMAGE, volunteer.getImage());
        args.putString(ARG_SIGNUP, volunteer.getUrl());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            org1 = getArguments().getString(ARG_ORG);
            mission1 = getArguments().getString(ARG_MISSION);
            image1 = getArguments().getString(ARG_IMAGE);
            signup1 = getArguments().getString(ARG_SIGNUP);
            Log.e("OrgURL:", signup1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_display, container, false);
        org2 = rootview.findViewById(R.id.org);
        image = rootview.findViewById(R.id.image);
        mission = rootview.findViewById(R.id.mission_body);

        signup = rootview.findViewById(R.id.sign_up);
        like = rootview.findViewById(R.id.favorite_button);


        org2.setText(org1);

        mission.setText(mission1);
        signup.setText("Sign Up");

        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Picasso.get().load(image1).fit().into(image);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("URL: ", "onClick: " + signup1);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(signup1));
                startActivity(browserIntent);
            }
        });
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if clicked once added to faves if not , nothing,
                //add toast to top of page
                Toast toast = Toast.makeText(getContext(), "Added to Faves", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            mListener = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
