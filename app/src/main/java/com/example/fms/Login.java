package com.example.fms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fms.model.Login_data;
import com.example.fms.remote.ApiUtils;
import com.example.fms.remote.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
TextView txt;
    UserService userService;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login=(Button) findViewById(R.id.login_btn);
        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.pass);
        userService = ApiUtils.getUserService();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String password = pass.getText().toString();
                //validate form
                if(validateLogin(username, password)){
                    //do login
                    doLogin(username, password);
                }

            }
        });
    }
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void doLogin(final String username,final String password){
        // Call call = userService.login(username,password);
        Call<Login_data> call = userService.login(username,password);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("mssg","bhr");
                if(response.isSuccessful()){
                    Log.d("mssg","danna");

                    Log.w("onResponse json ",new Gson().toJson(response.body()));

                    Log.w("pretty printed gson",new GsonBuilder().setPrettyPrinting().create().toJson(response));


                    Login_data logindata = (Login_data) response.body();
                    //Log.d("onResponse", "" + ((Login_data) response.body()).getBuss_name());
                    String a= logindata.getUserid();
                    Log.d("userid",""+a);
                    if(logindata.getMessage().equals("1")){
                        //login start main activity
                        Intent intent = new Intent(Login.this, bussnissactivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                        overridePendingTransition(R.anim.start, R.anim.exit);

                    } else {
                        Toast.makeText(Login.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("tost",""+t.getMessage());
            }
        });
    }
}
