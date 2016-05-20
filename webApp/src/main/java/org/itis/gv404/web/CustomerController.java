package org.itis.gv404.web;

import org.apache.taglibs.standard.extra.spath.Step;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.service.CustomerService;
import org.itis.gv404.util.exception.CustomerNotFoundException;
import org.itis.gv404.util.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("customers", customerService.getAll());

        return "customers";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getCustomerById(ModelMap model, @PathVariable String id) {
        Object response = null;
        String error = "";
        try {
            response = customerService.findCustomerById(Integer.parseInt(id));
        } catch (Exception e) {
            error = e.getMessage();
        }

        model.addAttribute("error", error);
        model.addAttribute("customer", response);

        return "customer";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute Customer customer, BindingResult result) {
        new CustomerValidator().validate(customer, result);
        if (result.hasErrors()){
            return "customer";
        }
        try {
            customerService.findCustomerById(customer.getId());
            customerService.updateCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            customerService.addCustomer(customer);
        }

        return "redirect:/customer/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomerById(Integer.parseInt(id));
        return "redirect:/customer/all";
    }

}
