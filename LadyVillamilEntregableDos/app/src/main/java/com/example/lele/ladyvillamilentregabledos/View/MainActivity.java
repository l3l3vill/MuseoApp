package com.example.lele.ladyvillamilentregabledos.View;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lele.ladyvillamilentregabledos.Model.Paint;

import com.example.lele.ladyvillamilentregabledos.Utils.Util;

public class MainActivity extends AppCompatActivity implements PaintRecycler_Fragment.InterfaceGetInformation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.printHash(this);

        //INSTANCIO FRAGMENT
        PaintRecycler_Fragment paintRecycler_fragment = new PaintRecycler_Fragment();
        //COMUNICACION FRAGMENT ACTIVITY

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.containerMainActivity, paintRecycler_fragment).commit();
    }


    @Override
    public void getInformation(Paint paint) {

        //hacer el fragment donde está el detalle de la pintura y hacerle la comunicación. creaer las key
        /*//Toast.makeText(this, "Estoy en la MainActivity", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString(DetalleRecetaFragment.KEY_TITULO,receta.getTitulo());
        bundle.putString(DetalleRecetaFragment.KEY_INGERDIENTES,receta.getIngredientes());
        bundle.putString(DetalleRecetaFragment.KEY_PREPARACION,receta.getPreparacion());

        DetalleRecetaFragment detalleRecetaFragment = new DetalleRecetaFragment();

        detalleRecetaFragment.setArguments(bundle);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.container, detalleRecetaFragment).commit();*/

    }


}
