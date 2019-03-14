package com.example.momoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MonHoc> monHocList = new ArrayList<>();
    MonHocAdapter adapter;
    ListView listView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    void init() {
        listView = findViewById(R.id.Main_lv);
        imageView = findViewById(R.id.back);
    }

    void Add() {
        monHocList.add(new MonHoc("Android Cơ Bản", "2TH123", 2, "Lê hồng sơn", 1706020071, "TIN HỌC ƯNG DUNG", "momo"));
        monHocList.add(new MonHoc("Lập trình Java", "2CD622", 3,"Lê hồng sơn", 1706020071, "TIN HỌC ỨNG DỤNG","momo"));
        monHocList.add(new MonHoc("Lập trình C#", "3DS123", 4,"Lê hồng sơn", 1706020071, "TIN HỌC ỨNG DỤNG", "momo"));
    }
}
