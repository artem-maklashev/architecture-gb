package org.example.views;

import org.example.models.Table;

import java.util.Collection;

public class BookingView {

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }
}
