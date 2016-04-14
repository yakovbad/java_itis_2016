package org.itis.gv404.service;


import org.itis.gv404.domain.Brand;
import org.itis.gv404.domain.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class CarService {
    private static List<Car> carList;

    static {
        Brand brand1 = new Brand();

        brand1.setId((long) 1);

        brand1.setName("Mercedes");

        brand1.setCountry("Germany");
        Brand brand2 = new Brand();

        brand2.setId((long) 2);

        brand2.setName("Peugeot");

        brand2.setCountry("France");
        Car car1 = new Car();

        car1.setId((long) 1);

        car1.setBrand(brand1);

        car1.setModel("SL 500");

        car1.setPrice(new BigDecimal(40000));

        Car car2 = new Car();

        car2.setId((long) 2);

        car2.setBrand(brand2);

        car2.setModel("607");

        car2.setPrice(new BigDecimal(35000));

        carList = new LinkedList<Car>();

        carList.add(car1);

        carList.add(car2);
    }

    public List<Car> getAllCar() {
        return carList;
    }

    public void addCar(Car car) {
        car.setId((long) carList.size() + 1);
        car.setBrand(new BrandService().getBrandById(car.getBrandId()));
        carList.add(car);
    }
}
