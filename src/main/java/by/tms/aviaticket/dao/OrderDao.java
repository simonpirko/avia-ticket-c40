package by.tms.aviaticket.dao;

import by.tms.aviaticket.entity.Order;
import by.tms.aviaticket.entity.User;

import java.util.List;

public interface OrderDao {
    void add(Order user);
    Order getById(long id);
    List<Order> getAll();
    List<Order> getByUser(User user);
    void remove(long id);
}
