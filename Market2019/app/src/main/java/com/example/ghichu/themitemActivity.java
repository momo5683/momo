package com.example.ghichu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.sanphamAdapter;
import com.example.market2019.R;
import com.example.model.Product;
import com.example.model.Card;
import com.example.DB.DB;

import java.util.Calendar;

public class themitemActivity extends AppCompatActivity {

    ListView listView;
    TextView textViewContent;
    LinearLayout linearAdd;
    LinearLayout back;
    TextInputEditText txtSP, txtNgay;
    Button btnAdd;
    EditText txtMT, txtGia,txtKhoiLuong;
    Card card;
    sanphamAdapter adapter;
    EditText edtTenSP;
    private int mYear, mMonth, mDay;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_item);
        card = new Card();
        onInit();
        onEvent();

        adapter = new sanphamAdapter(themitemActivity.this, R.layout.mathang, card.getProducts());
        adapter.setiShowChecked(false);
        adapter.setEditAble(false);
        listView.setAdapter(adapter);
        textViewContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proName = txtMT.getText().toString().trim();
                String proPrice = txtGia.getText().toString().trim();
                String proweight = txtKhoiLuong.getText().toString().trim();

                card.getProducts().add(new Product(proName, Integer.parseInt(proPrice),proweight));
                adapter.notifyDataSetChanged();
                txtMT.setText("");
                txtGia.setText("");
                txtKhoiLuong.setText("");
                txtMT.requestFocus();
            }
        });

    }



    private void onEvent() {
        linearAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setCardName(txtSP.getText().toString().trim());
                card.setDate(txtNgay.getText().toString().trim());

                DB.saveCard(themitemActivity.this, card);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (back != null)
                    DB.saveLoinInfo(themitemActivity.this, null);
                Intent intent = new Intent(themitemActivity.this, GhichuActivity.class);
                startActivity(intent);
                Toast.makeText(themitemActivity.this, "Succefully Back", Toast.LENGTH_SHORT).show();
            }
        });

        txtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(themitemActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                txtNgay.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }

    private void onInit() {
        textViewContent = findViewById(R.id.tv_content);
        linearAdd = findViewById(R.id.linearSave);
        txtSP = findViewById(R.id.txtSP);
        txtNgay = findViewById(R.id.txtNgay);
        back = findViewById(R.id.linearLogout);
        listView = findViewById(R.id.lvSP);
        btnAdd = findViewById(R.id.btnAdd);
        txtMT = findViewById(R.id.txtMT);
        txtGia = findViewById(R.id.txtGia);
        txtKhoiLuong = findViewById(R.id.txtKL);
        edtTenSP = findViewById(R.id.txtSP);


    }
}

