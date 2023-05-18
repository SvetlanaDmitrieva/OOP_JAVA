package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.views.BookingView;
import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Станислав");
        bookingView.reservationTable(new Date(), 2, "Станислав");
        bookingView.reservationTable(new Date(), 3, "Николай");
        bookingView.reservationTable(new Date(), 3, "Андрей");
        bookingView.reservationTable(new Date(), 4, "Иван");
        bookingView.reservationTable(new Date(), 5, "Николай");

        bookingView.changeReservationTable(1003, new Date(), 2, "Станислав");
    }
}
