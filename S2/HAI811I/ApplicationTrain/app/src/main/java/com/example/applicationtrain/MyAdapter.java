package com.example.applicationtrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Trip> trips;

    public MyAdapter(Context context, List<Trip> trips) {
        this.context = context;
        this.trips = trips;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.priceText.setText(trips.get(position).getPrice());
        holder.finishText.setText(trips.get(position).getFinish());
        holder.startText.setText(trips.get(position).getStart());
        holder.hFinishText.setText(trips.get(position).gethFinish());
        holder.hStartText.setText(trips.get(position).gethStart());
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
