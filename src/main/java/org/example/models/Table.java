package org.example.models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private static int counter;
    private final int id;
    private final Collection<Reservation> resevations = new ArrayList<>();
    { id = ++counter;}

    public int getId() {
        return id;
    }

    public Collection<Reservation> getResevations() {
        return resevations;
    }

    @Override
    public String toString() {
        return String.format("Table %d", id);
    }
}
