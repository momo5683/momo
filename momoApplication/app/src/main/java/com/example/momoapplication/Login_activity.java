package com.example.momoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        init();
        if (checkNull()){
            if (username.getText().toString().equals("root") && password.getText().toString().equals("admin")){
                Intent intent = new Intent(Login_activity.this, MainActivity.class);
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
    void init(){
        username = findViewById(R.id.main_edtUsername);
        password = findViewById(R.id.main_edtPassword);
    }
    boolean checkNull(){
        boolean check  =false;
        if (username.getText().toString().equals("")){
            username.setError("Null");

        }else if (password.getText().toString().equals("")){
            password.setError("Null");
        }else {
            check =true;
        }
        return check;
    }
}
