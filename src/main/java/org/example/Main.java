package org.example;

import org.example.models.TableModel;
import org.example.presenter.BookingPresenter;
import org.example.presenter.Model;
import org.example.presenter.View;
import org.example.views.BookingView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();
        view.reservationTable(new Date(),2, "Artem ");


        //Реализована замена столика в рамках домашней работы
        view.changeReservationTable( 1000, new Date(), 3, "Artem");
    }
}
