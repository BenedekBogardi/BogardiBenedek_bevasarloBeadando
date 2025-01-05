package com.example.bevasarlo_beadando;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity {

    private ListView termekList;
    private LinearLayout fromLinear;
    private TextView nev;
    private TextView egysegAr;
    private TextView mennyiseg;
    private TextView mertekEgyseg;
    private Button vissza;
    public void loadTermekek(RetrofitApiService apiService) {

        init();

        apiService.getAllTermekek().enqueue(new Callback<List<Termekek>>() {
            @Override
            public void onResponse(Call<List<Termekek>> call, Response<List<Termekek>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    termekList.clear();
                    termekList.addAll(response.body());
                    termekekAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(termekList.getContext(), "Hiba1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Termekek>> call, Throwable t) {
                Toast.makeText(termekList.getContext(), "Hiba2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init(){
        termekList=findView
    }
}
