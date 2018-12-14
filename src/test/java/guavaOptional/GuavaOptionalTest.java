package guavaOptional;

import com.google.common.base.Optional;
import guavaOptional.domain.Pizza;
import guavaTest.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GuavaOptionalTest {


    private GuavaOptionalAPI guavaOptionalAPI;

    @Before
    public void setUp() {
        guavaOptionalAPI = new GuavaOptionalAPI();
    }

    @Test
    public void testIsAbsent() {
        Optional absentOptional= guavaOptionalAPI.returnAbsentOptional();
        Assert.assertFalse(absentOptional.isPresent());
    }

    @Test
    public void testCarNotExist() {
        Optional<Car> carOptional= guavaOptionalAPI.existCarByBrand("mazda");
        Assert.assertFalse(carOptional.isPresent());
    }

    @Test
    public void testCarExist() {
        Optional<Car> carOptional= guavaOptionalAPI.existCarByBrand("kia");
        Assert.assertTrue(carOptional.isPresent());
    }

    @Test
    public void testMayBeNull() {
        Assert.assertFalse(guavaOptionalAPI.mayReturnNull(null).isPresent());
    }

    @Test
    public void testMayBeNullButIsValid() {
        Assert.assertTrue(guavaOptionalAPI.mayReturnNull("val").isPresent());
        Assert.assertEquals(guavaOptionalAPI.mayReturnNull("val").orNull(),"val");
    }


    @Test
    public void shouldSetVegetableTasteHateIF() {

        // GIVEN
        Pizza pizza = null;
        Optional<Pizza> pizzaOpt = Optional.of(pizza);




        // Hate IF :(
        if(!pizzaOpt.isPresent()){
            pizza = new Pizza();
        }
        pizza.setTaste("Vegetables :( ");


        Assert.assertEquals("Vegetables :( ",pizza.getTaste());

//######################################################################################

        //NO IF YAHOOOO :)
        pizza = pizzaOpt.or(new Pizza());
        pizza.setTaste("Vegetables :( ");

        Assert.assertEquals("Vegetables :( ",pizza.getTaste());

    }


}
