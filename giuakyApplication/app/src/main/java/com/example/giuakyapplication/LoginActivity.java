package com.example.giuakyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giuakyapplication.IView.ILogin;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edtUserName;
    EditText edtPassword;
    Button btnLogin;
    String mUserName = "";
    String mPassword = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onInit();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onValidateForm()){
                    Map<String,String> mMap = new HashMap<>();
                    mMap.put("user_name",mUserName);
                    mMap.put("password",mPassword);
                    new LoginAsyncTask(LoginActivity.this,new ILogin() {
                        @Override
                        public void onLoginSuccess(String m) {
                            Toast.makeText(LoginActivity.this,m,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, DienThoaiActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onLoginFail(String m) {
                            Toast.makeText(LoginActivity.this,m,Toast.LENGTH_SHORT).show();
                        }
                    },mMap).execute("http://www.vidophp.tk/api/account/signin");
                }
            }
        });
    }
    private void onInit() {
        edtUserName = findViewById(R.id.Login_edtUsername);
        edtPassword = findViewById(R.id.Login_edtPassword);
        btnLogin = findViewById(R.id.Login_btnLogin);
    }
    private boolean onValidateForm(){
        mUserName = edtUserName.getText().toString();
        if (mUserName.length() < 1){
            edtUserName.setError("Username field cannot be blank");
            return false;
        }

        mPassword = edtPassword.getText().toString();
        if (mPassword.length() < 1){
            edtPassword.setError("Password field cannot be blank");
            return  false;
        }
        return true;
    }
}
