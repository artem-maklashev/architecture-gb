package org.example;

import org.example.inmempry.ModelStore;
import org.example.inmempry.Observer1;
import org.example.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();

        List<Point3D> points = Arrays.asList(new Point3D(0,0,0), new Point3D(1,1,1));

        Poligon poligon = new Poligon(points);

        PoligonalModel poligonalModel = new PoligonalModel( Arrays.asList(poligon));

        Flash flash = new Flash(new Point3D(2,2,2), new Angle3D(1,1,1), new Color(), 2.5f);

        Camera camera = new Camera(new Point3D(3,3,3), new Angle3D(0,0,0));

        Scene scene = new Scene(List.of(poligonalModel), List.of(camera));

        ModelStore modelStore = new ModelStore( Arrays.asList(poligonalModel), List.of(scene), List.of(flash), List.of(camera));
        modelStore.registerModelChanger(observer1);

        List<Poligon> poligons = new ArrayList<>();
        poligons.add(new Poligon( Arrays.asList(new Point3D(0,0,0), new Point3D(1,1,1))));

        modelStore.addPoligonalModel(new PoligonalModel(poligons));

        System.out.println(modelStore.getScene(5001).toString());

    }
}