package org.itis.gv404.util.validator;


import org.itis.gv404.domain.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Order order = (Order) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", "field.required", "Required Field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required Field");

        if(! errors.hasFieldErrors("price")){
            if (order.getPrice() <= 0){
                errors.rejectValue("price", "not_negative", "Can't be negative or zero!");
            }
        }
    }
}
