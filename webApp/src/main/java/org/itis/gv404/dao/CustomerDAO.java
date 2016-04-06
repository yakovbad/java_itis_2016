package org.itis.gv404.dao;


import org.itis.gv404.domain.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();

    void addCustomer(Customer customer);

    Customer findById(Integer id);

    void deleteCustomerById(Integer id);

    void updateCustomer(Customer customer);
}
