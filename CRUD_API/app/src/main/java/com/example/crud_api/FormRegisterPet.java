package com.example.crud_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FormRegisterPet extends AppCompatActivity {

    EditText edt_name, edt_height, edt_weight, edt_category;

    CheckBox chkMale, chkFemale;

    Button btnDangKy, btnUpdate;

    ImageView btnPrevious;

    String url = "https://60ade79280a61f0017331e5a.mockapi.io/Pet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register_pet);

        anhXa();

        Intent intent = getIntent();
        int idPet = intent.getIntExtra("idPet", 0);
        String namePet = intent.getStringExtra("namePet");
        String categoryPet = intent.getStringExtra("categoryPet");
        int height = intent.getIntExtra("heightPet", 0);
        int weight = intent.getIntExtra("weightPet", 0);
        boolean sex = intent.getBooleanExtra("sexPet", true);

        if (namePet != null) {
            btnDangKy.setVisibility(View.GONE);
            btnUpdate.setVisibility(View.VISIBLE);

            edt_name.setText(namePet);
            edt_category.setText(categoryPet);
            edt_height.setText(height + "");
            edt_weight.setText(weight + "");
            if (sex == true)
                chkMale.setChecked(true);
            else
                chkFemale.setChecked(true);
        }else
            chkMale.setChecked(true);

        checkEvent();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putData(url, idPet);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormRegisterPet.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData(url);
            }
        });
    }

    private void putData(String url, int idPet) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.PUT, url + '/' + idPet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(FormRegisterPet.this, "Update Successfully!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FormRegisterPet.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("idPet", idPet + "");
                params.put("namePet", edt_name.getText().toString() + "");
                params.put("categoryPet", edt_category.getText().toString() + "");
                params.put("height", Integer.parseInt(edt_height.getText().toString()) + "");
                params.put("weight", Integer.parseInt(edt_weight.getText().toString()) + "");
                if (chkMale.isChecked())
                    params.put("sex", true + "");
                else if (chkFemale.isChecked())
                    params.put("sex", false + "");

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void checkEvent() {
        chkMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkMale.isChecked() == false)
                    chkFemale.setChecked(true);
                else
                    chkFemale.setChecked(false);
            }
        });

        chkFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkFemale.isChecked() == false)
                    chkMale.setChecked(true);
                else
                    chkMale.setChecked(false);
            }
        });
    }

    private void postData(String url) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(FormRegisterPet.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FormRegisterPet.this, "Lỗi khi thêm dữ liệu!", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Random random = new Random();
                int id = random.nextInt(1000);
                HashMap<String, String> params = new HashMap<>();
                params.put("idPet", id + "");
                params.put("namePet", edt_name.getText().toString() + "");
                params.put("categoryPet", edt_category.getText().toString() + "");
                params.put("height", Integer.parseInt(edt_height.getText().toString()) + "");
                params.put("weight", Integer.parseInt(edt_weight.getText().toString()) + "");
                if (chkMale.isChecked())
                    params.put("sex", true + "");
                else if (chkFemale.isChecked())
                    params.put("sex", false + "");

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void anhXa() {
        edt_category = findViewById(R.id.edt_category);
        edt_height = findViewById(R.id.edt_height);
        edt_name = findViewById(R.id.edt_name);
        edt_weight = findViewById(R.id.edt_weight);

        chkMale = findViewById(R.id.chkMale);
        chkFemale = findViewById(R.id.chkFemale);

        btnDangKy = findViewById(R.id.btnDangKy);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnUpdate = findViewById(R.id.btnUpdate);
    }
}