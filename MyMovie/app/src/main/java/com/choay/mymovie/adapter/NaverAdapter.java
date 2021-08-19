package com.choay.mymovie.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.mymovie.model.MovieDTO;

import java.util.List;

public class NaverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieDTO> movieList;

    public MovieViewAdapter

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
