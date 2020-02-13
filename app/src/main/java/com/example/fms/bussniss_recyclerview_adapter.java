package com.example.fms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fms.model.bussiness_data;

import java.util.ArrayList;


/**
 * Created by Hassan Jani on 12/11/2018.
 */

public class bussniss_recyclerview_adapter extends RecyclerView.Adapter<bussniss_recyclerview_adapter.ItemViewHolder> {
    String[] s = {"1","2","3","4","5" };
    ArrayList<bussiness_data> listdata = new ArrayList<bussiness_data>();

    Context context;

    public bussniss_recyclerview_adapter(Context context, ArrayList<bussiness_data> listdata) {
        this.context = context;
        this.listdata=listdata;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.bussniss_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, final int i) {

        itemViewHolder.title.setText(listdata.get(i).getBuss_name());
        itemViewHolder.mainDisplayItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id",listdata.get(i).getId());
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slidedown, R.anim.slideup);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView mainDisplayItemLayout;
        TextView title;
   //     TextView name, category, date, title, description;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mainDisplayItemLayout = (CardView) itemView.findViewById(R.id.mainDisplayItemLayout);
             title =(TextView) itemView.findViewById(R.id.tittle);
        }
    }
}
