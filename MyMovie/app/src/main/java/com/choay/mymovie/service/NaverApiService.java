package com.choay.mymovie.service;

import com.choay.mymovie.model.MovieDTO;

public interface NaverApiService {

    public MovieDTO getNaverData(String search);
}
