package jsr303;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StoreBeanTest {

    @Test
    public void testBeanJsr() {

        StoreBean member = new StoreBean();

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<StoreBean>> violations = validator.validate(member);
        assertEquals(violations.size(), 1);
    }
}
