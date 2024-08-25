package org.example.notes.core.infrastructure.persistance;

public abstract class DbContext {
    protected Database db;

    public DbContext(Database db) {
        this.db = db;
    }

    public boolean saveChanges() {
        //TODO: Сохранение изменений в БД
        return true;
    }

    public abstract void onModelCreating(ModelBuilder builder);
}
class ModelBuilder {
    public ModelBuilder applyConfiguration(ModelConfiguration config) {
        //TODO: Добавление конфигурации маппинга объекта некоторого ипа к структуре таблицы БД
        return this;
    }
}