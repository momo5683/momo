package com.example.market2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ShoppingCardAdapter;
import com.example.model.ShoppingCard;
import com.example.DB.DB;

import java.util.ArrayList;

public class GhichuActivity extends AppCompatActivity {

    LinearLayout linearLogout, linearAdd;
    ListView listView;
    TextView textViewContent;

    private ShoppingCardAdapter adapter;
    private ArrayList<ShoppingCard> listCard;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichu);
        onInit();
        onEvent();
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadDatasFromDatabase();
    }

    private void loadDatasFromDatabase() {
        listCard = DB.getAllCard(GhichuActivity.this);
        adapter = new ShoppingCardAdapter(GhichuActivity.this, R.layout.ghichu_item, listCard);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               ShoppingCard card = listCard.get(position);
               // Product card = new Product("jhdj",77,"jdd");
                Intent intent = new Intent(GhichuActivity.this, ChiTietActivity.class);
                intent.putExtra("CT",card);
                startActivity(intent);
            }
        });
    }

    private void onEvent() {
        linearAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GhichuActivity.this, themitemActivity.class);
                startActivity(intent);
            }
        });
        linearLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(GhichuActivity.this)
                        .setTitle("Title")
                        .setMessage("Do you really want to logout the application?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                DB.saveLoinInfo(GhichuActivity.this, null);
                                Intent intent = new Intent(GhichuActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(GhichuActivity.this, "Succefully Logout", Toast.LENGTH_SHORT).show();

                                Toast.makeText(GhichuActivity.this, "Done", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();


            }
        });

    }
    private void onInit() {
        listView = findViewById(R.id.Market);
        textViewContent = findViewById(R.id.tv_content);
        linearLogout = findViewById(R.id.linearLogout);
        linearAdd = findViewById(R.id.linearAdd);

    }

}


