package org.itis.gv404.service;


import org.itis.gv404.domain.Order;
import org.itis.gv404.util.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    void addOrder(Order order);

    Order findOrderById(Integer id) throws OrderNotFoundException;

    void updateOrder(Order order);

    void deleteOrderById(Integer id);
}
