package com.example.lele.ladyvillamilentregabledos.DAO;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class DaoHelper {
    protected Retrofit retrofit;

    public DaoHelper (String base_url){
        OkHttpClient.Builder httClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        retrofit =
                builder.client(httClient.build()).build();

    }

}
