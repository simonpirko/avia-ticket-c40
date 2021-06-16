package by.tms.aviaticket.dao.inmemory;

import by.tms.aviaticket.dao.OrderDao;
import by.tms.aviaticket.entity.Order;
import by.tms.aviaticket.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InMemoryOrderDao implements OrderDao {
    private final List<Order> orderList = new ArrayList<>();
    private static int incId = 1;
    @Override
    public void add(Order order) {
        order.setId(incId++);
        orderList.add(order);
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
        return orderList.stream().filter(order -> order.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public void remove(long id) {
        Order thisOrder = orderList.stream().filter(order -> order.getId() == id).findFirst().get();
        orderList.remove(thisOrder);
    }
}
