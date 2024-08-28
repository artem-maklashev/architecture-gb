package org.example.presenter;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date orderDate, int tableId, String name);
    void onChangeReservationTable(int orderId, Date orderDate, int tableId, String name);
}
