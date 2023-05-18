package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    /**
     * Получение всех доступных столиков
     * @return столики
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    int reservationTable(Date reservationDate, int tableNo, String name);
    /**
     * Удаление старого бронирования. Новое бронирование.
     * @param oldReservation номер старой брони
     * @param reservationDate дата нового бронирования
     * @param tableNo новый номер столика
     * @param name имя клиента
     * @return номер брони
     */
    
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name );
}
