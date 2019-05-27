package com.example.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        final Intent intent=new Intent(this,AddItemActivity.class);
        final Sessions session=new Sessions(getApplicationContext());
        final Intent intent1 = new Intent(this, MainActivity.class);

        Button addItem=(Button)findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Button adminLogout=findViewById(R.id.adminLogout);
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.adminLogout();
                startActivity(intent1);
            }
        });
    }
}
