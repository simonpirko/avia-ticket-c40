package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.OrderDao;
import by.tms.aviaticket.entity.Order;
import by.tms.aviaticket.entity.User;

import java.util.List;

public class InMemoryOrderDao implements OrderDao {
    @Override
    public void add(Order user) {

    }

    @Override
    public Order getById(long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getByUser(User user) {
        return null;
    }

    @Override
    public void remove(long id) {

    }
}
