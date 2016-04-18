package org.itis.gv404.dao;


import org.itis.gv404.domain.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll();

    void addOrder(Order order);

    Order findOrderById(Integer id);

    void deleteOrderById(Integer id);

    void updateOrder(Order order);
}
