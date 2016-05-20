package org.itis.gv404.service;


import org.itis.gv404.dao.CustomerDAO;
import org.itis.gv404.dao.OrderDAO;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.domain.Order;
import org.itis.gv404.util.exception.CustomerNotFoundException;
import org.itis.gv404.util.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerService customerService;

    @Transactional
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Transactional
    public void addOrder(Order order) {
        try {
            order.setCustomer(customerService.findCustomerById(order.getCustomerId()));
        }catch (Exception e){

        }

        orderDAO.addOrder(order);
    }

    @Transactional
    public Order findOrderById(Integer id) throws OrderNotFoundException {
        Order order;
        try {
            order = orderDAO.findOrderById(id);
        } catch (NullPointerException e){
            e.printStackTrace();
            throw new OrderNotFoundException();
        }
        return order;
    }

    @Transactional
    public void updateOrder(Order order) {
        Customer customer = customerService.findCustomerById(order.getCustomerId());
        order.setCustomer(customer);
        orderDAO.updateOrder(order);
    }

    @Transactional
    public void deleteOrderById(Integer id) {
        orderDAO.deleteOrderById(id);
    }
}
