package org.itis.gv404.dao;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.itis.gv404.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Customer> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
    }

    @Override
    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        if (customer == null)
            throw new NullPointerException();
        return customer;
    }

    @Override
    public void deleteCustomerById(Integer id) {
        Customer customer = findCustomerById(id);
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }
}
