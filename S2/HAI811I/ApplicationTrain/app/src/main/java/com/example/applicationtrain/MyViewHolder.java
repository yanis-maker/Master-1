package com.example.applicationtrain;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView priceText;
    TextView hStartText;
    TextView startText;
    TextView hFinishText;
    TextView finishText;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        priceText=itemView.findViewById(R.id.card_price);
        hStartText=itemView.findViewById(R.id.card_hStart);
        startText=itemView.findViewById(R.id.card_start);
        hFinishText=itemView.findViewById(R.id.card_hFinish);
        finishText=itemView.findViewById(R.id.card_finish);
    }
}
