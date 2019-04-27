package com.example.giuakyapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.giuakyapplication.IView.IView;
import com.example.giuakyapplication.Model.DienThoaiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DienThoaiActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DienThoaiModel> models;
    Map<String, String>mMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dienthoai);
        models = new ArrayList<>();
        recyclerView = findViewById(R.id.DienThoai_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mMap.put("id","15");
        new DienThoaiAsyncTask(DienThoaiActivity.this,new IView() {
            @Override
            public void onRequestSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {
                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        DienThoaiModel model = new DienThoaiModel();
                        model.setProduct(jsonObject.getString("product_name"));
                        model.setPrice(jsonObject.getString("price"));
                        model.setDescription(jsonObject.getString("description"));
                        model.setProducer(jsonObject.getString("description"));
                        model.setId(Integer.valueOf(jsonObject.getString("id")));
                        models.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MyViewAdapter adapter = new MyViewAdapter(DienThoaiActivity.this,R.layout.dienthoai_item,models);
                recyclerView.setAdapter(adapter);
            }
        },mMap).execute("http://www.vidophp.tk/api/account/getdata");

    }
}
