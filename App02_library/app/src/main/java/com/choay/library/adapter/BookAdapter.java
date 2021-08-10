package com.choay.library.adapter;

import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.library.databinding.ActivityMainBinding;
import com.choay.library.databinding.BookItemViewBinding;
import com.choay.library.model.BookDTO;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BookDTO> bookList ;

    public BookAdapter(List<BookDTO> bookDTOList) {
        this.bookList = bookDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        BookItemViewBinding bookItemViewBinding
                = BookItemViewBinding.inflate( layoutInflater, parent, false);

        RecyclerView.ViewHolder viewHolder = new BookViewHolder(bookItemViewBinding);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        BookViewHolder bookHolder = (BookViewHolder) holder;
        BookDTO bookDTO = bookList.get(position);

        TextView txt_title = bookHolder.bookItemView.itemTxtTitle;

        /*
        HtmlCompat.fromHtml()
        ,문자열 내에 HTML tag가 포함되어 있으면
        tag의 효과를 적용하여 문자열을 화면에 그리기 위한 변환 method

        Nougat(7.0)이상에서만 작됭되는 method
        Nougat 이하에서는 원래는 작동되었는데 최근 Android에선 제거되었다.
         */

        String str_title = "<font color=blue>" + bookDTO.getTitle() + "</font>";
        str_title = "<span style = 'color:#565656;'";
        str_title += bookDTO.getTitle() +"</span>";

        txt_title.setText(
                HtmlCompat.fromHtml(
                        str_title, HtmlCompat.FROM_HTML_MODE_LEGACY
                )
        );

        Spannable span = (Spannable) txt_title.getText();
        span.setSpan(new ForegroundColorSpan(Color.BLUE),0,txt_title.getText().length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }

    @Override
    public int getItemCount() {
        return bookList == null ? 0 : bookList.size() ;
    }


    /*
    각 데이터 item을 표현하기 위한 view 객체 생성하기
     */
    public static class BookViewHolder extends RecyclerView.ViewHolder {

        /*
        DataBinding이 true로 되어 있을 때
        book_item_view.xml layout 파일을 생성하면
        자동으로 선언되는 클래스

        DataBinding을 선언하면
        layout,xml에 선언된 Component를 일일히 한 개 씩 세팅하지 않아도
        binding 객체 한 개만 세팅하면 나머지는 자동으로 같이 세팅이 된다.

         */
        public BookItemViewBinding bookItemView ;

        public BookViewHolder(@NonNull BookItemViewBinding bookItemViewBinding) {
            super(bookItemViewBinding.getRoot());
            bookItemView = bookItemViewBinding;
        }

        public void bind(BookDTO bookDTO) {

        }


    }


}
