package org.itis.gv404.util.validator;


import org.itis.gv404.domain.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "field.required", "Required Field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "field.required", "Required Field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "field.required", "Required Field");

        if(! errors.hasFieldErrors("age")){
            if (!CustomerValidatorUtil.validateAge(customer)){
                errors.rejectValue("age", "not_negative", "Can't be negative or zero!");
            }
        }
    }
}
