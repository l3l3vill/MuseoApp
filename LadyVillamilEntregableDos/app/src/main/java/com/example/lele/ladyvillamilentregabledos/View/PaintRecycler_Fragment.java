package com.example.lele.ladyvillamilentregabledos.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lele.ladyvillamilentregabledos.Controller.PaintController;
import com.example.lele.ladyvillamilentregabledos.Model.Paint;
import com.example.lele.ladyvillamilentregabledos.R;
import com.example.lele.ladyvillamilentregabledos.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaintRecycler_Fragment extends Fragment implements AdapterRecycler.AdapterInterface {

    //ATRIBUTOS
    private InterfaceGetInformation notificador;
    private AdapterRecycler adapterRecyclerPaint;



    public PaintRecycler_Fragment() {
        // Required empty public constructor
    }

    //ON ATTACH castear contexto
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificador = (InterfaceGetInformation) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paint_recycler, container, false);

        //instancio adaptador
        adapterRecyclerPaint = new AdapterRecycler(new ArrayList<Paint>(),this);

        //buscamos la view
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewPaints);

        //performance
        recyclerView.setHasFixedSize(true);

        //layoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterRecyclerPaint);


        //instanciamos controller
        PaintController paintController = new PaintController();
        paintController.getPaint(new ResultListener<List<Paint>>() {
            @Override
            public void finish(List<Paint> Result) {
                adapterRecyclerPaint.setPaintList(Result);

            }
        }, getContext());

        return view;
    }

    @Override
    public void changeActivity (Paint paint) {
        notificador.getInformation(paint);

    }

    //INTERFACE NOTIFICADOR
    public interface InterfaceGetInformation{
        public void getInformation(Paint paint);
    }
}
