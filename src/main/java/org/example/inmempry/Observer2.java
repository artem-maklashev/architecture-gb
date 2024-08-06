package org.example.inmempry;

public class Observer2 implements IModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Произошло изменение в хранилище моделей - обозреватель №2");
    }
}
