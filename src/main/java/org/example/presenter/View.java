package org.example.presenter;

import org.example.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {
    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void showReservationTableResult(int reservationId);
    void reservationTable(Date orderDate, int tableId, String name);
    void  changeReservationTable(int orderId, Date orderDate, int tableId, String name);
}
