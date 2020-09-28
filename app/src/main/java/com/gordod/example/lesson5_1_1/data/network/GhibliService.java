package com.gordod.example.lesson5_1_1.data.network;

import android.util.Log;
import android.widget.EditText;

import com.gordod.example.lesson5_1_1.Tags;
import com.gordod.example.lesson5_1_1.data.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class GhibliService {
    private final static String
//            GHIBLI_API_FILMS = "films/{filmId}",
            GHIBLI_API_FILMS = "films/",
            GHIBLI_API_FILM_ID = "filmId",
            GHIBLI_API_BASE_URL = "https://ghibliapi.herokuapp.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GHIBLI_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getFilmList(GhibliFilmCallback callback){
//        Call<FilmModel> call = service.getFilmById(id);
        Call<List<FilmModel>> call = service.getFilmList();
        call.enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() && response.body() != null)
                    callback.onSuccess(response.body());
                else Log.e(Tags.ERROR.toString(), "Film model is empty");

            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public interface GhibliApi {
        @GET(GHIBLI_API_FILMS)
        Call<List<FilmModel>> getFilmList();
//        getFilmById(@Path(GHIBLI_API_FILM_ID) String filmId);
    }

    public interface GhibliFilmCallback {
        void onSuccess(List<FilmModel> filmModelList);
        void onFailure(Throwable t);
    }
}
