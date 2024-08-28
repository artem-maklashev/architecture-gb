package org.example.models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000;
    private int id;
    private String name;
    private Date date;
    private Table table;
    {
        id = counter++;
    }

    public Reservation(String name, Date date, Table table) {
        this.name = name;
        this.date = date;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
