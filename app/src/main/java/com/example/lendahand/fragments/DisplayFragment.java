package com.example.lendahand.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lendahand.FragmentInterface;
import com.example.lendahand.R;
import com.squareup.picasso.Picasso;

public class DisplayFragment extends Fragment {
    private View rootview;

    private TextView org2;
    private ImageView image;
    private TextView mission;
    private Button signup;

    private String org;
    private String mission1;
    private String signup1;


    private FragmentInterface mListener;

    public DisplayFragment() {

    }


    public static DisplayFragment newInstance() {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_display, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        org2 = rootview.findViewById(R.id.org);
        image = rootview.findViewById(R.id.image);
        mission = rootview.findViewById(R.id.mission);
        signup = rootview.findViewById(R.id.sign_up);

        org2.setText(org);
        mission.setText(mission1);
        signup.setText(signup1);
//        Picasso.get().load(volunteer.getImage()).fit().into(image);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
