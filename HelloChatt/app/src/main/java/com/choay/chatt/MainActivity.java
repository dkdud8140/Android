package com.choay.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.choay.chatt.adapter.chattAdapter;
import com.choay.chatt.model.chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //chatt 메시지를 전달하는 view들
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // chatt 메시지를 표현할 ciew들
    private RecyclerView chat_list_view ;
    private chattAdapter chattAdapter;
    private List<chatt> chattList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);

        // 0. 보여줄 데이터 객체 새성
        chattList = new ArrayList<chatt>();

        chatt chatt = new chatt();
        chatt.setName("접니다");
        chatt.setMsg("하이룰");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("당근당근");
        chatt.setMsg("팔아요");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("바니바니");
        chatt.setMsg("삽니다");
        chattList.add(chatt);


        // 1.Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해 주어야 한다.
        chattAdapter = new chattAdapter(chattList);

        // 2.RecyclerView.Adapter와 RecyclerView를 서로 연결
        chat_list_view.setAdapter(chattAdapter);

        // 3.RecyclerView의 데이터를 표현하는데 사용할 레이아웃 매너저 설정하기
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

    }
}