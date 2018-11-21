package com.example.lele.ladyvillamilentregabledos.DAO;

import com.example.lele.ladyvillamilentregabledos.Model.PaintContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicePaint {
    @GET("bins/x858r")
    Call<PaintContainer> bringPaint();

    @GET("bins/x858r")
    Call<PaintContainer> bringPaintPerName(@Query("name") String name);

    @GET("bins/x858r")
    Call<PaintContainer> bringPaintPerId(@Query("artistId") Integer artistId);
}
