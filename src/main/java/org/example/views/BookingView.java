package org.example.views;

import org.example.models.Table;
import org.example.presenter.View;
import org.example.presenter.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showReservationTableResult(int reservationId) {
        if (reservationId > 0) {System.out.printf("Столик успешно забронирован. Номер брони %d\n", reservationId);
        } else {
            System.out.println("Бронирование столика не удалось.");
        }
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public void reservationTable(Date orderDate, int tableId, String name){
        if (observer != null) {
            observer.onReservationTable(orderDate, tableId, name);
        }
    }

    @Override
    public void changeReservationTable(int orderId, Date orderDate, int tableId, String name) {
        if (observer != null) {
            observer.onChangeReservationTable(orderId, orderDate,tableId, name);
        }
    }

}
