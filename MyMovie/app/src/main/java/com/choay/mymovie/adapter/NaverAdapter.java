package com.choay.mymovie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.mymovie.R;
import com.choay.mymovie.model.MovieDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NaverAdapter extends RecyclerView.Adapter {

    private List<MovieDTO> movieList;

    public NaverAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.movie_item_view,parent,false);

        MovieItemHolder viewHolder = new MovieItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieItemHolder = (MovieItemHolder) holder;

        MovieDTO movieDTO = movieList.get(position);

        String item_title = movieDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title, Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.item_title.setText( sp_title);

        String item_dir = movieDTO.getDirector();
        movieItemHolder.item_dir.setText( "감독 : "+item_dir);
        String item_action = movieDTO.getActor();
        movieItemHolder.item_action.setText( "출연배우 : "+item_action);
        String item_pubDate = movieDTO.getPubDate();
        movieItemHolder.item_pubDate.setText( "출시연도 : "+item_pubDate);

        if(!movieDTO.getImage().isEmpty()) {
            Picasso.get().load(movieDTO.getImage()).into(movieItemHolder.item_image);
        }


    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieItemHolder extends RecyclerView.ViewHolder{

        public TextView item_title;
        public ImageView item_image;
        public TextView item_dir;
        public TextView item_action;
        public TextView item_pubDate;


        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.movie_item_title);
            item_image = itemView.findViewById(R.id.movie_item_image);
            item_dir = itemView.findViewById(R.id.movie_item_dir);
            item_action = itemView.findViewById(R.id.movie_item_action);
            item_pubDate = itemView.findViewById(R.id.movie_item_pubDate);
        }
    }


}
