package com.example.androidlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Bundle extras = getIntent().getExtras();
        String userName;
        String useremail;
        long userphone;
        TextView name=(TextView)findViewById(R.id.name);
        TextView email=(TextView)findViewById(R.id.email);
        TextView phone=(TextView)findViewById(R.id.phone);

            userName = extras.getString("name");
            // and get whatever type user account id is
            useremail=extras.getString("email");
            userphone=extras.getLong("phone");
            name.setText(userName);
            email.setText(useremail);
            phone.setText(String.valueOf(userphone));

        Log.e("NAME",String.valueOf(userphone));
    }
}
