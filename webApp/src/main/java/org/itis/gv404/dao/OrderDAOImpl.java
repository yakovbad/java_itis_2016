package org.itis.gv404.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.itis.gv404.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order findOrderById(Integer id) {
        Order order = (Order) sessionFactory.getCurrentSession()
                .createCriteria(Order.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        if (order == null)
            throw new NullPointerException();
        return order;
    }

    @Override
    public void deleteOrderById(Integer id) {
        Order order = findOrderById(id);
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().merge(order);
    }
}
