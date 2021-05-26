package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.TicketDao;
import by.tms.aviaticket.entity.Ticket;

import java.util.List;

public class InMemoryTicketDao implements TicketDao {
    @Override
    public void add(Ticket ticket) {

    }

    @Override
    public Ticket getById(long id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public List<Ticket> getByFlight(String placeOfDeparture, String placeOfArrival) {
        return null;
    }

    @Override
    public boolean contains(Ticket ticket) {
        return false;
    }

    @Override
    public void remove(long id) {

    }
}
