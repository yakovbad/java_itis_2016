package org.itis.gv404.controller;

import org.itis.gv404.domain.Car;
import org.itis.gv404.service.BrandService;
import org.itis.gv404.service.CarService;
import org.itis.gv404.validator.CarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    BrandService brandService;

    @Autowired
    CarValidator carValidator;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("listCar", carService.getAllCar());

        return "cars";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("car", new Car());
        model.addAttribute("brandList", brandService.getBrandList());
        return "car";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car, BindingResult result) {
        carValidator.validate(car, result);
        if(result.hasErrors()){
            return "car";
        }
        carService.addCar(car);
        return "redirect:/cars";
    }
}
