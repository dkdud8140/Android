package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {

    private TextView view_id = null ;
    private TextView view_password = null ;
    private TextView view_name = null ;
    private TextView view_addr = null ;
    private TextView view_tel = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        view_id = findViewById(R.id.view_id);
        view_password = findViewById(R.id.view_password);
        view_name = findViewById(R.id.view_name);
        view_addr = findViewById(R.id.view_addr);
        view_tel = findViewById(R.id.view_tel);

        Intent intent = getIntent();

        String id = intent.getExtras().getString("id");
        String password = intent.getExtras().getString("password");
        String name = intent.getExtras().getString("name");
        String addr = intent.getExtras().getString("addr");
        String tel = intent.getExtras().getString("tel");

        view_id.setText(id);
        view_password.setText(password);
        view_name.setText(name);
        view_addr.setText(addr);
        view_tel.setText(tel);

    }
}