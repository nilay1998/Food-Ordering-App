package com.example.androidlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidlogin.Retrofit.FoodPrice;
import com.example.androidlogin.Retrofit.MenuItem;
import com.example.androidlogin.Retrofit.NetworkClient;
import com.example.androidlogin.Retrofit.RequestService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddItemActivity extends AppCompatActivity {

    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<Integer> mPrice=new ArrayList<>();
    private ArrayList<FoodPrice> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final EditText itemName=(EditText)findViewById(R.id.itemName);
        final EditText itemPrice=(EditText)findViewById(R.id.itemPrice);
        Button addItem=(Button)findViewById(R.id.addButton);

//        mNames.add("Dahi");
//        mPrice.add(25);

        final RecyclerView recyclerView=findViewById(R.id.recyclerView);
        final RecyclerViewAdapter adapter=new RecyclerViewAdapter(mNames,mPrice,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = NetworkClient.getRetrofitClient();

        final RequestService requestService=retrofit.create(RequestService.class);
        Call<MenuItem> call=requestService.getMenuItem();
        call.enqueue(new Callback<MenuItem>() {
            @Override
            public void onResponse(Call<MenuItem> call, Response<MenuItem> response) {
                if(response.body().getStatus().equals("1"))
                {
                    data = new ArrayList<>((Arrays.asList(response.body().getFoodPrice())));
                    for(int i=0;i<data.size();i++)
                    {
                        mNames.add(data.get(i).getFood());
                        mPrice.add(data.get(i).getPrice());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<MenuItem> call, Throwable t) {

            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String food=itemName.getText().toString();
                final String price=itemPrice.getText().toString();
                Call<MenuItem> call=requestService.addMenuItem(food,price);

                call.enqueue(new Callback<MenuItem>() {
                    @Override
                    public void onResponse(Call<MenuItem> call, Response<MenuItem> response) {
                        Toast.makeText(AddItemActivity.this,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        if(response.body().getStatus().equals("1"))
                        {
                            mNames.add(food);
                            mPrice.add(Integer.parseInt(price));
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<MenuItem> call, Throwable t) {
                        Toast.makeText(AddItemActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.e("Error",t.getMessage());
                    }
                });
                itemName.setText("");
                itemPrice.setText("");
            }
        });
    }
}
