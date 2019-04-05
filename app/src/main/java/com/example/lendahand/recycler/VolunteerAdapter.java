package com.example.lendahand.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lendahand.FragmentInterface;
import com.example.lendahand.R;
import com.example.lendahand.model.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerViewHolder> {
    private final FragmentInterface fragmentListener;

    List<Volunteer> volunteerList = new ArrayList<>();

    public VolunteerAdapter(FragmentInterface fragmentListener) {
        this.fragmentListener = fragmentListener;
    }

    public void setVolunteerList(@NonNull List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VolunteerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_view, viewGroup, false);
        return new VolunteerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolunteerViewHolder volunteerViewHolder, int i) {
        volunteerViewHolder.onBind(volunteerList.get(i),fragmentListener);

    }

    @Override
    public int getItemCount() {
        return volunteerList.size();
    }
}
