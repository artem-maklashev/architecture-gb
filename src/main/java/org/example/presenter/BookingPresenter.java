package org.example.presenter;

import org.example.models.Table;
import org.example.models.TableModel;
import org.example.views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private final Model tableModel;
    private final View bookingView;


    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        this.bookingView.setObserver(this);
    }

    public Collection<Table> loadTables() {
        return tableModel.loadTables();
    }

    public void updateUIShowTables() {
        bookingView.showTables(loadTables());
    }

    public void updateUIShowReservationResult(int reservationId) {
        if (reservationId > 0) {
            bookingView.showReservationTableResult(reservationId);
        }
    }

    @Override
    public void onReservationTable(Date orderDate, int tableId, String name) {
        int reservationInfo = tableModel.reservationTable(orderDate, tableId, name);
        updateUIShowReservationResult(reservationInfo);
    }

    @Override
    public void onChangeReservationTable(int orderId, Date orderDate, int tableId, String name) {
        int reservationInfo = tableModel.changeReservationTable(orderId, orderDate, tableId, name);
        updateUIShowReservationResult(reservationInfo);
    }
}
