package com.example.fms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by Hassan Jani on 12/11/2018.
 */

public class details_recyclerview_adapter extends RecyclerView.Adapter<details_recyclerview_adapter.ItemViewHolder> {

    Context context;
    String[] s = {"Assests","Libility","Owner Equity","Income","Expenses" };
    public details_recyclerview_adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.details_main, parent, false);
        return new ItemViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.title.setText(s[i]);
    }

    @Override
    public int getItemCount() {
        return s.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView mainDisplayItemLayout;
        TextView title;
   //     TextView name, category, date, title, description;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mainDisplayItemLayout = (CardView) itemView.findViewById(R.id.mainDisplayItemLayout);
            title =(TextView) itemView.findViewById(R.id.title);

        }
    }
}
