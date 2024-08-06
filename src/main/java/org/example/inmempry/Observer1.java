package org.example.inmempry;

public class Observer1 implements IModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Произошло добавление в хранилище - обозреватель №1");
    }
}
