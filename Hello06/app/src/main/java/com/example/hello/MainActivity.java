package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView myImg = null;
    private int count = 0 ;
    prvate int[] images = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImg = findViewById(R.id.myImg);
        images = new Int[3];
        images[0] = R.drawable.logo_black;
        images[1] = R.drawable.logo_navy;
        images[2] = R.drawable.logo_yellow;

        myImg.setOnClickListener(view->{
            count ++;
            int intNum = count %3 ;
            myImg.setImageResource(intNum);

        });
    }

}