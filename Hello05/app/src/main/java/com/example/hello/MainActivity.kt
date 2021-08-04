package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private ImageView myImg = null ;
    private int count = 0 ;

    override fun onCreate(savedInstanceState: Bundle?) {

        myImg = findViewById(R.id.my_img)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}