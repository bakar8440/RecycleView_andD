package com.example.listapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recycleview extends AppCompatActivity {
    RecyclerView recycleview ;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycleview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        recycleview = findViewById(R.id.recycleview1);

        recycleview.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter=new MyAdapter(this);
        recycleview.setAdapter(myAdapter);


        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recycleview.addItemDecoration(dividerItemDecoration);




    }
}