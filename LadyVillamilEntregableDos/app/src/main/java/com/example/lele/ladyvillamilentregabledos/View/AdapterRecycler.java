package com.example.lele.ladyvillamilentregabledos.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lele.ladyvillamilentregabledos.Model.Paint;
import com.example.lele.ladyvillamilentregabledos.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter {

    //ATRIBUTOS
    private List<Paint> paintList = new ArrayList<>();
    private AdapterInterface adapterInterface;

    //CONSTRUCTOR
    public AdapterRecycler(List<Paint> paintList, AdapterInterface adapterInterface) {
        this.paintList = paintList;
        this.adapterInterface = adapterInterface;
    }

    //SETTER

    public void setPaintList(List<Paint> paintList) {
        this.paintList = paintList;
        notifyDataSetChanged();//para actualizar recycler

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_cardview,viewGroup,false);
        PaintViewholder paintViewholder = new PaintViewholder(view);

        return paintViewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Paint paint = paintList.get(i);
        PaintViewholder paintViewholder = (PaintViewholder) viewHolder;
        paintViewholder.cargarDatos(paint);

    }

    @Override
    public int getItemCount() {
        return paintList.size();
    }

    //VIEWHOLDER
    public class PaintViewholder extends RecyclerView.ViewHolder{
        //ATRIBUTOS
        private ImageView imageViewPaint;
        private TextView textViewTittle;




       //CONSTRUCTOR
        public PaintViewholder(@NonNull View itemView) {
            super(itemView);
            imageViewPaint = itemView.findViewById(R.id.imageViewPaint);
            textViewTittle = itemView.findViewById(R.id.tvTittlePaint);

            //CLICK
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paint paint = paintList.get(getAdapterPosition());
                    adapterInterface.changeActivity(paint);
                }
            });

        }

        public void cargarDatos (Paint paint){
            textViewTittle.setText(paint.getName());
            Glide.with(itemView.getContext()).load(paint.getImage()).into(imageViewPaint);
        }
    }

    public interface AdapterInterface{
        void changeActivity (Paint paint);
    }


}
