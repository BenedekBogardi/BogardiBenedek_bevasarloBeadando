package com.example.bevasarlo_beadando;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText nev;
    private EditText egysegAr;
    private EditText mennyiseg;
    private EditText mertekEgyseg;
    private TextView bruttoAr;
    private Button gomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        RetrofitApiService apiService = RetrofitClient.getInstance().create(RetrofitApiService.class);

        ListActivity listActivity = new ListActivity();

        gomb.setOnClickListener(v -> {
            Boolean i;
            try {
                String n = nev.getText().toString();
                Integer e = Integer.parseInt(egysegAr.getText().toString());
                Double mennyisegDouble = Double.parseDouble(mennyiseg.getText().toString());
                String mertek = mertekEgyseg.getText().toString();
                bruttoAr.setText("Bruttó ár: " + (Math.round(e*mennyisegDouble*100)/100) + "Ft");
                i = true;
            }
            catch (Exception e){
                Toast.makeText(this, "Hibás bemenet", Toast.LENGTH_SHORT).show();
                i = false;
            }
            if(i){
                gomb.setVisibility(View.GONE);
                listActivity.loadTermekek(apiService);
            }
        });
    }

    public void init(){
        nev=findViewById(R.id.nev);
        egysegAr=findViewById(R.id.egysegAr);
        mennyiseg=findViewById(R.id.mennyiseg);
        mertekEgyseg=findViewById(R.id.mertekEgyseg);
        bruttoAr=findViewById(R.id.bruttoAr);
        gomb=findViewById(R.id.gomb);
    }
}