package com.example.momoapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MonHocAdapter extends ArrayAdapter<MonHoc> {
    List<MonHoc> monHocList;
    Context context;
    int resouce;
    public MonHocAdapter(Context context, int resource, List<MonHoc> objects) {
        super(context, resource, objects);
        this.monHocList = objects;
        this.context =context;
        this.resouce = resource;
    }
    class ViewHolder{
        TextView tenMonHoc;
        TextView maMonHoc;
        TextView soTinChi;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder =new ViewHolder();
        if(rowView == null){
            rowView = LayoutInflater.from(context).inflate(resouce, parent,false);

            viewHolder.tenMonHoc = rowView.findViewById(R.id.ct_txt_tenMonHoc);
            viewHolder.maMonHoc = rowView.findViewById(R.id.ct_txt_maMonHoc);
            viewHolder.soTinChi = rowView.findViewById(R.id.ct_txt_soTinChi);
            rowView.setTag(viewHolder);
        }else {
            viewHolder =(ViewHolder)rowView.getTag();
        }
        MonHoc monHoc  = monHocList.get(position);

        viewHolder.tenMonHoc.setText(monHoc.getTenMonHoc());
        viewHolder.maMonHoc.setText(monHoc.getMaMonHoc());
        viewHolder.soTinChi.setText(monHoc.getSoTinChi());
        return rowView;
    }
}

