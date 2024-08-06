package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class PoligonalModel {

    private List<Poligon> poligons = new ArrayList<>();
    private List<Texture> textures = new ArrayList<>();

    public PoligonalModel(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public PoligonalModel(List<Poligon> poligons, List<Texture> textures) {
        this.poligons = poligons;
        this.textures = textures;
    }

    public void setPoligons(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public void setTextures(List<Texture> textures) {
        this.textures = textures;
    }

    @Override
    public String toString() {
        return "PoligonalModel{" +
                "poligons=" + poligons +
                ", textures=" + textures +
                '}';
    }
}
