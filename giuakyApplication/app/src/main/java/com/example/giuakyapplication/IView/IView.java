package com.example.giuakyapplication.IView;

import android.graphics.Bitmap;

import org.json.JSONArray;

public interface IView {
    void onRequestSuccess(Bitmap bitmap);
    void onGetDataSuccess(JSONArray jsonArray);
}