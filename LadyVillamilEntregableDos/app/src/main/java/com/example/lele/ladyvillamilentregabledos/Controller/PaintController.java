package com.example.lele.ladyvillamilentregabledos.Controller;

import android.content.Context;
import android.telecom.Call;

import com.example.lele.ladyvillamilentregabledos.DAO.DaoInternetPaint;
import com.example.lele.ladyvillamilentregabledos.Model.Paint;
import com.example.lele.ladyvillamilentregabledos.Utils.ResultListener;
import com.example.lele.ladyvillamilentregabledos.Utils.Util;

import java.security.PrivateKey;
import java.util.List;

public class PaintController {

    public void getPaint (final ResultListener<List<Paint>> listenerView, Context context){
        if(Util.isOnline(context)){
            DaoInternetPaint daoInternetPaint = new DaoInternetPaint();
            daoInternetPaint.bringPaints(new ResultListener<List<Paint>>() {
                @Override
                public void finish(List<Paint> Result) {
                    listenerView.finish(Result);
                }
            });
        }else{
            //BASE DE DATOS
        }
    }

    public void getPaintPerName (String name, final ResultListener<List<Paint>> listenerView, Context context){
        if (Util.isOnline(context)){
            DaoInternetPaint daoInternetPaint = new DaoInternetPaint();
            daoInternetPaint.bringPaintsPerName(name, new ResultListener<List<Paint>>() {
                @Override
                public void finish(List<Paint> Result) {
                    listenerView.finish(Result);
                }
            });
        }else {
            //base De Datos
        }
    }

    public void getPaintPerId (Integer id, final ResultListener<List<Paint>> listenerView, Context context ) {
        if (Util.isOnline(context)) {
            DaoInternetPaint daoInternetPaint = new DaoInternetPaint();
            daoInternetPaint.bringPaintsPerId(id, new ResultListener<List<Paint>>() {
                @Override
                public void finish(List<Paint> Result) {
                    listenerView.finish(Result);
                }
            });
        } else {

        }
    }
}
