package com.example.lele.ladyvillamilentregabledos.DAO;

import com.example.lele.ladyvillamilentregabledos.Model.Paint;
import com.example.lele.ladyvillamilentregabledos.Model.PaintContainer;
import com.example.lele.ladyvillamilentregabledos.Utils.ResultListener;

import java.security.PublicKey;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DaoInternetPaint extends DaoHelper{
    //CONSTANTE
    private static final String BASE_URL = "https://api.myjson.com/";
    private ServicePaint servicePaint;

    //CONSTRUCTOR le quito los parámetros y le paso la constante a Super
    public DaoInternetPaint() {
        super(BASE_URL);
        this.servicePaint = retrofit.create(ServicePaint.class);
    }

    public void bringPaints (final ResultListener<List<Paint>> listenerController){
        Call<PaintContainer> call = servicePaint.bringPaint();//con esta call traemos la api
        call.enqueue(new Callback<PaintContainer>() {
            @Override
            public void onResponse(Call<PaintContainer> call, Response<PaintContainer> response) {
                PaintContainer paintContainer = response.body();
                List<Paint> paintList = paintContainer.getPaints();
                listenerController.finish(paintList);

            }

            @Override
            public void onFailure(Call<PaintContainer> call, Throwable t) {

            }
        });//esto es para traer la info de forma asíncrona
    }

    public void bringPaintsPerName(String name, final ResultListener<List<Paint>> listenerControler){
        Call<PaintContainer> call = servicePaint.bringPaintPerName(name);
        call.enqueue(new Callback<PaintContainer>() {
            @Override
            public void onResponse(Call<PaintContainer> call, Response<PaintContainer> response) {
                PaintContainer paintContainer = response.body();
                List<Paint> paintList = paintContainer.getPaints();
                listenerControler.finish(paintList);
            }

            @Override
            public void onFailure(Call<PaintContainer> call, Throwable t) {

            }
        });
    }

    public void bringPaintsPerId (Integer id, final ResultListener<List<Paint>> listenerControler){
        Call<PaintContainer> call = servicePaint.bringPaintPerId(id);
        call.enqueue(new Callback<PaintContainer>() {
            @Override
            public void onResponse(Call<PaintContainer> call, Response<PaintContainer> response) {
                PaintContainer paintContainer = response.body();
                List<Paint> paintList = paintContainer.getPaints();
                listenerControler.finish(paintList);
            }

            @Override
            public void onFailure(Call<PaintContainer> call, Throwable t) {

            }
        });
    }
}
