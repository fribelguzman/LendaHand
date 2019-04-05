package com.example.lendahand.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lendahand.FragmentInterface;
import com.example.lendahand.R;
import com.example.lendahand.fragments.ItemViewFragment;
import com.example.lendahand.model.Volunteer;
import com.squareup.picasso.Picasso;

public class VolunteerViewHolder extends RecyclerView.ViewHolder {
    private ImageView icon;
    private TextView org;
    private TextView catg;

    public VolunteerViewHolder(@NonNull View itemView) {
        super(itemView);
        icon =itemView.findViewById(R.id.icon_image);
        org = itemView.findViewById(R.id.org1);
        catg = itemView.findViewById(R.id.catg);
    }
    public void onBind(Volunteer volunteer, FragmentInterface fragmentListener){
        org.setText(volunteer.getOrginization());
        catg.setText(volunteer.getCategory());
        Picasso.get().load(volunteer.getImage()).fit().into(icon);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.showDisplayFragment();
            }
        });


        }
    }

