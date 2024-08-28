package org.example.models;

import org.example.presenter.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservDate, int tableNumber, String name) {
        for (Table table : tables) {
            if (table.getId() == tableNumber) {
                Reservation re = new Reservation(name, reservDate, table);
                table.getResevations().add(re);
                return re.getId();
            }
        }
        return -1;
    }
}