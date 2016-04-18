package org.itis.gv404.service;


import org.itis.gv404.dao.CustomerDAO;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.util.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Transactional
    public Customer findCustomerById(Integer id) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerDAO.findCustomerById(id);
        } catch (NullPointerException e){
            e.printStackTrace();
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Transactional
    public void deleteCustomerById(Integer id) {
        customerDAO.deleteCustomerById(id);
    }
}
