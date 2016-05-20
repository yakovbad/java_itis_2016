package org.itis.gv404.util.validator;


import org.itis.gv404.domain.Customer;

public class CustomerValidatorUtil {
    public static boolean validateAge(Customer customer){
        return customer.getAge() > 0;
    }
}
