package org.itis.gv404.web;

import org.itis.gv404.dao.CustomerDAOImpl;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Customer> customers = customerService.getAll();
        for(Customer customer: customers){
            System.out.println(customer);
        }
        model.addAttribute("message", "Hello23");
        return "home";
    }

}
