package com.example.giuakyapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.giuakyapplication.Model.DienThoaiModel;

import java.util.List;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.ViewHolder> {
    List<DienThoaiModel> models;
    int mResource;
    Context mContext;
    public MyViewAdapter(Context context,int resource, List<DienThoaiModel> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewAdapter.ViewHolder viewHolder, int i) {
        DienThoaiModel model = models.get(i);
        viewHolder.edtsp.setText(model.getProduct());
        viewHolder.edtgia.setText(model.getPrice());
        viewHolder.edtmt.setText(model.getDescription());
        viewHolder.edtsx.setText(model.getProducer());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText edtsp;
        private EditText edtgia;
        private  EditText edtmt;
        private EditText edtsx;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edtsp = itemView.findViewById(R.id.dienthoai_edt_product);
            this.edtgia = itemView.findViewById(R.id.dienthoai_edt_price);
            this.edtmt = itemView.findViewById(R.id.dienthoai_edt_description);
            this.edtsx = itemView.findViewById(R.id.dienthoai_edt_producer);
        }
    }
}
