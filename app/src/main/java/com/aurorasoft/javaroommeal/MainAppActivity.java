package com.aurorasoft.javaroommeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainAppActivity extends AppCompatActivity {
    DataAdapter adapter;
    List<Meal> meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        showRecyclerView();
    }

    void showRecyclerView(){
        RecyclerView view = (RecyclerView) findViewById(R.id.rv_meal);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        view.setLayoutManager(mLayoutManager);

        meals = MainActivity.db.dataDao().getAll(); //ambil semua data

        adapter = new DataAdapter(meals, this);
        view.setAdapter(adapter);

    }
}
