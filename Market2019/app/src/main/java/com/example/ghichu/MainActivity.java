package com.example.ghichu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.market2019.R;
import com.example.model.UserModel;
import com.example.DB.DB;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OntInit();
        Onvalidayfrom();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Onvalidayfrom()) {
                    if (edtUsername.getText().toString().endsWith("momo") && edtPassword.getText().toString().equals("momo")) {
                        UserModel userModel = new UserModel(edtUsername.getText().toString().trim(), edtPassword.getText().toString().trim());
                        DB.saveLoinInfo(MainActivity.this, userModel);
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, GhichuActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "login fail!!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
    private boolean Onvalidayfrom() {
        if (edtUsername.getText().toString().length() < 1) {
            edtUsername.setError("fail");
            return false;
        }
        if (edtPassword.getText().toString().length() < 1) {
            edtPassword.setError("fail");
            return false;
        }
        return true;
    }

    private void OntInit() {
        edtUsername = findViewById(R.id.txtUsername);
        edtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.Button);


    }
}
