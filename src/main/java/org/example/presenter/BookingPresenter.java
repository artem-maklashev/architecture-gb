package org.example.presenter;

import org.example.models.TableModel;
import org.example.views.BookingView;

public class BookingPresenter {
    private final Model tableModel;
    private final View bookingView;


    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
    }
}
