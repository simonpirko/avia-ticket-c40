package by.tms.aviaticket.service;

import by.tms.aviaticket.dao.OrderDao;
import by.tms.aviaticket.entity.Order;
import by.tms.aviaticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public List<Order> getCurrentOrders(User user) {
        List<Order> byUser = orderDao.getByUser(user);

        return byUser.stream().filter(order -> order.getOrderDate().isAfter(LocalDateTime.now().plusHours(1))).collect(Collectors.toList());
    }
    public List<Order> getPaidHistory(User user) {
        List<Order> byUser = orderDao.getByUser(user);

        return byUser.stream().filter(order -> order.getOrderDate().isBefore(LocalDateTime.now())).collect(Collectors.toList());
    }

    public void save(Order order){
        orderDao.add(order);
    }

    public void remove(long id){
        orderDao.remove(id);
    }

}
