package com.example.listapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    Button button;
    EditText input;

    @SuppressLint("MissingInflatedId")
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

        listView = findViewById(R.id.list);
        button = findViewById(R.id.button);
        input = findViewById(R.id.input);

        arrayList.add("Mango");
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Pineapple");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this, "This is Item: " + arrayList.get(i), Toast.LENGTH_SHORT).show();
            arrayList.remove(i);
            arrayAdapter.notifyDataSetChanged();
        });

        button.setOnClickListener(v -> {
            String name = input.getText().toString();
            if (!name.isEmpty()) {
                arrayList.add(name);
                arrayAdapter.notifyDataSetChanged();
                input.setText(""); // Clear input field after adding
            } else {
                Toast.makeText(MainActivity.this, "Please enter a valid item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
