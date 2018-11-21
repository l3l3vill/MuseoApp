package com.example.lele.ladyvillamilentregabledos.Model;

import java.util.List;

public class PaintContainer {
    //ATRIBUTOS
    private List<Paint> paints;

    //CONSTRUCTOR
    public PaintContainer(List<Paint> paints) {
        this.paints = paints;
    }

    //GETTER
    public List<Paint> getPaints() {
        return paints;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "PaintContainer{" +
                "paints=" + paints +
                '}';
    }
}
