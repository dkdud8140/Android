package com.choay.chatt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.chatt.R;
import com.choay.chatt.model.chatt;

import java.util.List;

/*
RecyclerView.Adapter 구현한 클래스
RecyclerVIew에 데이터를 표현하고자 할 때 사용하는 Helper 클래스(도와주는 도구 클래스)
 */
public class chattAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<chatt> cattList;

    public chattAdapter(List<chatt> cattList) {
        this.cattList = cattList ;
    }

    /*
    chat_item.xml 파일을 읽어서 한 개의 아이템을 화면에 그릴 준비
     */

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*
        LayoutInflater.from().inflate(chatt_item)

        chatt_item.xml 파일은 한개의 파일이 화면 전체를 구성하지 않고
        여기에서는 RecyclerView 내부에 각각 데이터 아이템을 그릴 도구로 사용이 된다.

        이러한 layout은 setContentView()를 사용하지 않고
        layoutInfalter.inflalte() 함수를 사용하여 만든다.
         */

        View item_layout =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.chatt_item,parent,false);

        ChattViewHolder viewHolder = new ChattViewHolder(item_layout);

        return viewHolder;
    }



    // chattList에서 한 개의 데이터를 getter하여
    // chat_item
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // 전체 chattList에서 현재 화면에 그릴 item 추출하기
        chatt chatt = cattList.get(position);

        ChattViewHolder chattViewHolder = (ChattViewHolder) holder;


        // chat_item.xml의 TextView 객체에 데이터 담기.
        chattViewHolder.item_name.setText(chatt.getName());
        chattViewHolder.item_msg.setText(chatt.getMsg());

    }


    /*
    RecycleVIew가 데이터들을 화면에 표시할 때 참조하는 함수
    @return
     */
    @Override
    public int getItemCount() {
        return cattList == null ? 0 : cattList.size();
    }

    // class 내부에 in class
    public static class ChattViewHolder extends RecyclerView.ViewHolder{

        public TextView item_name;
        public TextView item_msg;

        // 각 테이터를 표현하기 위한
        //

        public ChattViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_msg = itemView.findViewById(R.id.item_msg);
        }
    }


}
