import junit.framework.TestCase;
import org.itis.gv404.domain.Customer;
import org.itis.gv404.util.validator.CustomerValidator;
import org.itis.gv404.util.validator.CustomerValidatorUtil;

import java.util.Random;

public class CustomerValidatorTest extends TestCase{
    public void testSupportsValid(){
        CustomerValidator customerValidator = new CustomerValidator();
        assertTrue(customerValidator.supports(Customer.class));
    }

    public void testSupportsNotValid(){
        CustomerValidator customerValidator = new CustomerValidator();
        assertFalse(customerValidator.supports(Random.class));
    }

    public void testAgeValid(){
        Customer customer = new Customer();
        customer.setAge(10);
        customer.setFirstname("test");
        customer.setLastname("asd");
        assertTrue(CustomerValidatorUtil.validateAge(customer));
    }

    public void testAgeNotValid(){
        Customer customer = new Customer();
        customer.setAge(-45);
        customer.setFirstname("test");
        customer.setLastname("asd");
        assertFalse(CustomerValidatorUtil.validateAge(customer));
    }
}
