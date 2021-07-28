package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText input_id = null ;
    private TextInputEditText input_password = null ;
    private TextInputEditText input_name = null ;
    private TextInputEditText input_tel = null ;
    private TextInputEditText input_addr = null ;

    private Button btn_join = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_id = findViewById(R.id.input_id);
        input_password = findViewById(R.id.input_password);
        input_name = findViewById(R.id.input_name);
        input_addr = findViewById(R.id.input_addr);
        input_tel = findViewById(R.id.input_tel);

        btn_join = findViewById(R.id.btn_join);

        btn_join.setOnClickListener( view ->{

            String id = input_id.getText().toString();
            String password = input_password.getText().toString();
            String name = input_name.getText().toString();
            String addr = input_addr.getText().toString();
            String tel = input_tel.getText().toString();

            if(id.isEmpty()) {
                input_id.setError("id는 반드시 입력하세요");
                return;
            }
            if(password.isEmpty()) {
                input_password.setError("password는 반드시 입력하세요");
                return;
            }
            if(name.isEmpty()) {
                input_name.setError("이름은 반드시 입력하세요");
                return;
            }

            Intent intent_join = new Intent(MainActivity.this,JoinActivity.class);

            intent_join.putExtra("id", id);
            intent_join.putExtra("password", password);
            intent_join.putExtra("name", name);
            intent_join.putExtra("addr", addr);
            intent_join.putExtra("tel", tel);

            startActivity(intent_join);



        } );


    }
}