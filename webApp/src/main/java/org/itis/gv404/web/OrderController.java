package org.itis.gv404.web;

import org.itis.gv404.domain.Order;
import org.itis.gv404.service.CustomerService;
import org.itis.gv404.service.OrderService;
import org.itis.gv404.util.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getOrderById(ModelMap model, @PathVariable String id) {
        Object response = null;
        String error = "";
        try {
            response = orderService.findOrderById(Integer.parseInt(id));
        } catch (OrderNotFoundException e) {
            error = e.getMessage();
        }

        model.addAttribute("error", error);
        model.addAttribute("order", response);
        model.addAttribute("customers", customerService.getAll());
        return "order";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAll());
        return "order";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute Order order, BindingResult result) {
        try {
            orderService.findOrderById(order.getId());
            orderService.updateOrder(order);
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
            orderService.addOrder(order);
        }

        return "redirect:/order/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable String id) {
        orderService.deleteOrderById(Integer.parseInt(id));
        return "redirect:/order/all";
    }
}
