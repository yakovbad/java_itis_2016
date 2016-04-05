package org.itis.gv404.web;

import org.itis.gv404.domain.Customer;
import org.itis.gv404.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String test(ModelMap model, @PathVariable String id){
        Object response;
        try {
            response = customerService.findById(Integer.parseInt(id));
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            response = "Такой пользователь удален или еще не создан.";
        }
        model.addAttribute("customer", response);

        return "customer";
    }

}
