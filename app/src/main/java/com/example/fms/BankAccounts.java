package com.example.fms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fms.model.Bank_acc;
import com.example.fms.model.Login_data;
import com.example.fms.remote.ApiUtils;
import com.example.fms.remote.UserService;
import com.google.android.material.navigation.NavigationView;
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

public class BankAccounts extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    String buss_id;
    UserService userService;
    ArrayList<Bank_acc> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_accounts);

        buss_id = getIntent().getStringExtra("b_id");
        userService = ApiUtils.getUserService();

        Toast.makeText(this, "" + buss_id, Toast.LENGTH_SHORT).show();
        toolbar = (Toolbar) findViewById(R.id.articleToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.articleDrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.articleNavigationView);
        SetUpNavigation();
        listdata = new ArrayList<Bank_acc>();

        doLogin(buss_id);


    }

    private void SetUpNavigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.summry:
                        Intent intent = new Intent(BankAccounts.this, MainActivity.class);
                        Activity activity = (Activity) BankAccounts.this;
                        activity.startActivity(intent);
                        overridePendingTransition(R.anim.start, R.anim.exit);

                        break;
                    case R.id.bank:

                        break;
                    case R.id.cos:

                        break;
                }


                return true;
            }
        });
    }



    private void doLogin(final String username){
        // Call call = userService.login(username,password);
        Call<ArrayList<Bank_acc>> call  = userService.bank_accounts(username);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
//                Log.d("mssg","bhr");
                if(response.isSuccessful()){
//                    Log.d("mssg","danna");

                    Log.w("onResponse json ",new Gson().toJson(response.body()));

                    Log.w("pretty printed gson",new GsonBuilder().setPrettyPrinting().create().toJson(response));



//
//
//                    Bank_acc mydata = (Bank_acc) response.body();
//                    //Log.d("onResponse", "" + ((Login_data) response.body()).getBuss_name());
//                    String a= mydata.getAcc_no();
//                    Log.d("userid",""+a);
//                    if(mydata.getBank_nam().equals("1")){
//                        //login start main activity
//                        Intent intent = new Intent(BankAccounts.this, bussnissactivity.class);
//                        intent.putExtra("username", username);
//                        startActivity(intent);
//                        overridePendingTransition(R.anim.start, R.anim.exit);
//                    } else {
//                        Toast.makeText(BankAccounts.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(BankAccounts.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                }
//            }


            Gson gson = new GsonBuilder().create();
            //  JsonArray myCustomArray = gson.toJsonTree(listdata).getAsJsonArray();

            JSONArray jsonArray = null;

            String listString = gson.toJson(
                    response.body(),
                    new TypeToken<ArrayList<Bank_acc>>() {}.getType());

                    try {
                jsonArray =  new JSONArray(listString);
                Log.d("mssg",""+jsonArray.get(0).toString());

            } catch (
            JSONException e) {
                e.printStackTrace();
            }


            //                    // ResObj resObj = (ResObj) response.body();
                    Bank_acc mydata = new Bank_acc();
                    if (jsonArray != null) {
                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject a=jsonArray.getJSONObject(i);
                        String Acc_no=a.getString("acc_no");
                        String Acount_balance=a.getString("act_blnce");
                        String Bank_code=a.getString("bank_cod");
                        String Bank_name=a.getString("bank_nam");
                        String Clear_balance=a.getString("clear_blnce");
                        String Message=a.getString("message");
                        String Pending_deposit=a.getString("pend_dep");
                        String Pending_widrawl=a.getString("pend_with");
                        mydata.setAcc_no(Acc_no);
                        mydata.setAct_blnce(Acount_balance);
                        mydata.setBank_code(Bank_code);
                        mydata.setBank_nam(Bank_name);
                        mydata.setClear_blnce(Clear_balance);
                        mydata.setPend_dep(Pending_deposit);
                        mydata.setPend_with(Pending_widrawl);
                        listdata.add(mydata);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //      listdata.add(jsonArray(i));
                }


            }

            String a= listdata.get(0).getBank_code();
            String b= listdata.get(1).getBank_nam();
//
                    Log.d("msssg",""+a+" "+b+"");
//            storyRecyclerView = (RecyclerView) findViewById(R.id.story_RecyclerView);
//                    storyRecyclerView.setLayoutManager(new LinearLayoutManager(context));
//                    storyRecyclerView.setAdapter(new StoryRecyclerViewAdapter(context,listdata));


        } else {
            //  Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
        }
    }






    @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(BankAccounts.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("tost",""+t.getMessage());
            }
        });
    }


}
