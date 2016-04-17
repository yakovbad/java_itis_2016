package org.itis.gv404.web;

import org.apache.taglibs.standard.extra.spath.Step;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.GET)
    public String getById(ModelMap model, @PathVariable String id) {
        Object response;
        try {
            response = customerService.findById(Integer.parseInt(id));
            System.out.println(response);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            response = "Такой пользователь удален или еще не создан.";
        }
        model.addAttribute("customer", response);

        return "customer";
    }


    @RequestMapping(value = "/customer/add", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        try {
            customerService.findById(customer.getId());
            customerService.updateCustomer(customer);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            customerService.addCustomer(customer);
        }

        return "redirect:/customer/all";
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.GET)
    // todo change method
    public String deleteCustomer(ModelMap model, @PathVariable String id) {
        try {
            customerService.deleteCustomerById(Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return "redirect:/customer/all";
    }

}
