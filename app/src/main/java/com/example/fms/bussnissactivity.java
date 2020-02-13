package com.example.fms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.fms.model.Login_data;
import com.example.fms.model.bussiness_data;
import com.example.fms.remote.ApiUtils;
import com.example.fms.remote.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bussnissactivity extends AppCompatActivity {
    RecyclerView storyRecyclerView;
    UserService userService;
    ArrayList<bussiness_data> listdata;
    bussiness_data mydata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussnissactivity);

        listdata = new ArrayList<bussiness_data>();
//        storyRecyclerView = (RecyclerView) findViewById(R.id.busniss_recycle);
//        storyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        storyRecyclerView.setAdapter(new bussniss_recyclerview_adapter(this));
        userService = ApiUtils.getUserService();
        getdata();
    }
    void getdata(){
        Call<ArrayList<bussiness_data>> call = userService.bussniss_names();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){

                    Log.w("onResponse json" ,new Gson().toJson(response.body()));

                    Log.w("pretty printed gson",new GsonBuilder().setPrettyPrinting().create().toJson(response));
                    Gson gson = new GsonBuilder().create();
                    //  JsonArray myCustomArray = gson.toJsonTree(listdata).getAsJsonArray();
                    JSONArray jsonArray = null;
                    String listString = gson.toJson(response.body(), new TypeToken<ArrayList<bussiness_data>>() {}.getType());
                    try {
                        jsonArray =  new JSONArray(listString);
//                        Log.d("mssg",""+jsonArray.length());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    // ResObj resObj = (ResObj) response.body();
                    if (jsonArray != null) {
                        for (int i=0;i<jsonArray.length();i++){
                            mydata = new bussiness_data();
                            try {
                                JSONObject a=jsonArray.getJSONObject(i);
                                mydata.setId(a.getString("buss_id"));
                                mydata.setBuss_name(a.getString("buss_nam"));
//                                Log.d("mydata",""+i+" "+a.getString("buss_nam"));
                                listdata.add(mydata);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            Log.d("loop", "onResponse: "+listdata.get(i).getBuss_name());
                            //      listdata.add(jsonArray(i));
                        }
                    }






//                    for (int i = 0; i < listdata.size(); i++) {
//                        Log.d("outloop", "onResponse: "+listdata.get(i).getId()+"    "+listdata.get(i).getBuss_name());
//                    }




//                    String a= listdata.get(3).getBuss_name()+"       "+listdata.get(2).getBuss_name()+"    "+
//                            listdata.get(2).getBuss_name()+"         "+listdata.get(3).getBuss_name();
//                    int a=listdata.size();
//                    Log.d("msssg",String.valueOf(a));

        storyRecyclerView = (RecyclerView) findViewById(R.id.busniss_recycle);
        storyRecyclerView.setLayoutManager(new LinearLayoutManager(bussnissactivity.this));
        storyRecyclerView.setAdapter(new bussniss_recyclerview_adapter(bussnissactivity.this, listdata));

                } else {
                    Toast.makeText(bussnissactivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(bussnissactivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("tost",""+t.getMessage());
            }
        });
    }
}
