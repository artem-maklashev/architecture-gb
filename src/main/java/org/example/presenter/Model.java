package org.example.presenter;

import org.example.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();
    int reservationTable(Date reservDate, int tableNumber, String name);
}
