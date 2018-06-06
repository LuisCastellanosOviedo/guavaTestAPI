package guavaTest;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.contains;

public class GuavaTdd {


    Car carTest;
    Car carTest2;
    List<Car> carList;
    List<String> colores;

    @Before
    public void setUp() throws Exception {
        carTest= new Car();
        carTest.setColor("greene");
        carTest2 = new Car();
        carTest2.setColor("red");
        carList = GuavaApi.createList();
        carList.add(carTest);
        carList.add(carTest2);
        carList.add(null);

        colores= Arrays.asList("azul","red");
    }


    @Test
    public void joinStrings() {
        Assert.assertEquals("azul,red",GuavaApi.joinString(colores));
    }

    @Test
    public void testInitCollectiions() {
        Assert.assertNotNull(GuavaApi.createMap());
    }

    @Test
    public void testListNotNull() {
        Assert.assertNotNull(carList);
    }

    @Test
    public void testAddCarToHashmap() {

        Map<String,Car> map = GuavaApi.createMap();
        GuavaApi.addElementToMap(map,"key",carTest);
        Assert.assertEquals(1,map.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFilterWithPreconditions() {

        Preconditions.checkArgument( Lists.newArrayList().size()>0,"must not be empty");
    }


    @Test
    public void testPrecoditionsOk() {
        Preconditions.checkArgument(carList.size()>0,"must not be empty");
    }

    @Test
    public void filterlist() {
        Assert.assertEquals(2,GuavaApi.filterNullList(carList).size());
        Assert.assertEquals("greene",GuavaApi.filterNullList(carList).get(0).getColor());
    }


    @Test
    public void testCustomPredicate() {
        Assert.assertEquals(1,GuavaApi.filterCarByColor(carList).size());
        Assert.assertEquals("red",GuavaApi.filterCarByColor(carList).get(0).getColor());
    }

    @Test
    public void testAllCarsHasColors() {
        Assert.assertEquals(false,GuavaApi.allCarsHasColor(carList));
        Assert.assertEquals(true, GuavaApi.allCarsHasColor( GuavaApi.filterNullList(carList)));
    }


    @Test
    public void testConvertToCamioneta() {
       Assert.assertEquals(2, GuavaApi.convertToCamioneta( GuavaApi.filterNullList(carList)).size());
       Assert.assertEquals(Camioneta.class.getSimpleName(), GuavaApi.convertToCamioneta( GuavaApi.filterNullList(carList)).get(0).getClass().getSimpleName());
    }


    @Test
    public void testComposeFunctionsToKnowIFAnyhasRedColor() {
        Assert.assertEquals(2, GuavaApi.anyHasResColor(GuavaApi.filterNullList(carList)).size());
        Assert.assertThat(GuavaApi.anyHasResColor(GuavaApi.filterNullList(carList)),contains(false,true));
    }

    @Test
    public void listIsNull() {
        List<String> colors=null;
        GuavaApi.listIsNull(colors);
    }
}
