package by.tms.aviaticket.dao;

import by.tms.aviaticket.entity.Flight;
import by.tms.aviaticket.entity.Ticket;
import by.tms.aviaticket.entity.User;

import java.util.List;

public interface TicketDao {
    void add(Ticket ticket);
    Ticket getById(long id);
    List<Ticket> getAll();
    List<Ticket> getByFlight(String placeOfDeparture, String placeOfArrival);
    boolean contains(Ticket ticket);
    void remove(long id);
}
