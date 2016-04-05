package org.itis.gv404.service;


import org.itis.gv404.dao.CustomerDAO;
import org.itis.gv404.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List getAll() {
        return customerDAO.getAll();
    }
}
