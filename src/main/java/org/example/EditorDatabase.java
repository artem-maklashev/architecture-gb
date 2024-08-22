package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class EditorDatabase implements Database{

    private final ProjectFile projectFile;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка данных
    }

    @Override
    public void save() {
        //TODO: сохранить данные
    }

    @Override
    public Collection<Entity> getAll() {
        return List.of();
    }
}
