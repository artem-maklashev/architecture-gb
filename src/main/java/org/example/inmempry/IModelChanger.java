package org.example.inmempry;

public interface IModelChanger {
    void notifyChange();
    void registerModelChanger(IModelChangedObserver observer);
    void unregisterModelChanger(IModelChangedObserver observer);
}
