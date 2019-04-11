package com.example.ghichu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.sanphamAdapter;
import com.example.market2019.R;
import com.example.model.Card;
import com.example.DB.DB;

public class ChiTietActivity extends AppCompatActivity {
    TextView textViewTenSP;
    TextView textViewNgay;
    ListView listViewdetail;
    sanphamAdapter sanphamAdapter;
    LinearLayout back, linearDone;
    Card itemCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        onInit();
        onGetIntent();
        onEvent();
    }

    private void onEvent() {
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (back != null)
                    DB.saveLoinInfo(ChiTietActivity.this, null);
                Intent intent = new Intent(ChiTietActivity.this, GhichuActivity.class);
                startActivity(intent);
                Toast.makeText(ChiTietActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        linearDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCard.setProducts(sanphamAdapter.getList());
                itemCard.setDone(true);
                DB.saveCard(ChiTietActivity.this, itemCard);
                finish();
            }
        });
    }


    private void onGetIntent() {
        Intent intent = getIntent();
        itemCard = (Card) intent.getSerializableExtra("CT");
        if (itemCard != null) {
            textViewTenSP.setText(itemCard.getCardName());
            textViewNgay.setText((itemCard.getDate()));
            sanphamAdapter = new sanphamAdapter(ChiTietActivity.this, R.layout.mathang, itemCard.getProducts());
            sanphamAdapter.setiShowChecked(true);
            listViewdetail.setAdapter(sanphamAdapter);
            if(itemCard.isDone()){
                linearDone.setVisibility(View.GONE);
                sanphamAdapter.setEditAble(false);
            }else{
                linearDone.setVisibility(View.VISIBLE);
                sanphamAdapter.setEditAble(true);
            }
        }
    }

    private void onInit() {
        textViewTenSP= findViewById(R.id.TenTP);
        textViewNgay = findViewById(R.id.Ngay);
        listViewdetail = findViewById(R.id.lvChiTiet);
        back = findViewById(R.id.linearLogout);
        linearDone = findViewById(R.id.linearDone);

    }
}
