package com.choay.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.choay.library.service.NaverBookService;
import com.choay.library.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.book_list_view);
            NaverBookService nSer = new NaverBookServiceImplV1(recyclerView);
            nSer.getBooks("자바");
    }
}