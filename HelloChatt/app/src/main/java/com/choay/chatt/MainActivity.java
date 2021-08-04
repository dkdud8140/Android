package com.choay.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.choay.chatt.adapter.chattAdapter;
import com.choay.chatt.model.chatt;
import com.choay.chatt.service.FirebaseServiceImplV1;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //chatt 메시지를 전달하는 view들
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // chatt 메시지를 표현할 ciew들
    private RecyclerView chat_list_view;
    private chattAdapter chattAdapter;
    private List<chatt> chattList;

    //fireBase 와 연결하는 Connection을 위한 객체 선언
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);

        // 0. 보여줄 데이터 객체 생성
        chattList = new ArrayList<chatt>();

        // 1.Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해 주어야 한다.
        chattAdapter = new chattAdapter(chattList);

        // 2.RecyclerView.Adapter와 RecyclerView를 서로 연결
        chat_list_view.setAdapter(chattAdapter);

        // 3.RecyclerView의 데이터를 표현하는데 사용할 레이아웃 매너저 설정하기
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();
        // 사용할 table 생성
        // realtimeDatabase에서는 table을 path라는 개념으로 부른다
        dbRef = dbConn.getReference("chatting");

        // firebase로부터 데이터 변화 이벤트가 전달되면
        // 이벤트를 수신하여 할 일을 지정하기 위한 핸들러 선언
        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);

        //이벤트 핸들러 연결
        dbRef.addChildEventListener(childEventListener);

        /*
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
        */



        /*
        EditBox에 메시지를 입력하고 Send 버튼을 클릭했을 때 할 일 지정하기

        EditBox에 메시지를 입력하고 Send를 하면
        FireBase의 Realtime DatabASE에 insert하기기
        */
        btn_send.setOnClickListener(view -> {

            //EditBox에 입력 된 문자열을 추출하여 문자열 변수에 담기
            String msg = txt_msg.getText().toString();
            if (msg != null && !msg.isEmpty()) {

                String toastMsg = String.format("메시지 : %s", msg);
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();

                chatt chatVO = new chatt();
                chatVO.setMsg(msg);
                chatVO.setName("홍길동");

                // chattList.add(chatVO);
                // firebase의 realtime DB의 table에 데이터를 insert(push)하라
                dbRef.push().setValue(chatVO);
                txt_msg.setText("");
            }

        });


    }
}