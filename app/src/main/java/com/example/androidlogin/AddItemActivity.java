package com.example.androidlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<Integer> mPrice=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final EditText itemName=(EditText)findViewById(R.id.itemName);
        final EditText itemPrice=(EditText)findViewById(R.id.itemPrice);
        Button addItem=(Button)findViewById(R.id.addButton);

        mNames.add("Dahi");
        mPrice.add(25);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        final RecyclerViewAdapter adapter=new RecyclerViewAdapter(mNames,mPrice,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNames.add(itemName.getText().toString());
                mPrice.add(Integer.parseInt(itemPrice.getText().toString()));
                itemName.setText("");
                itemPrice.setText("");
                adapter.notifyDataSetChanged();
            }
        });
    }
}
