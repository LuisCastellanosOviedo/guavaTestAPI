import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ExcHandling {



    public String doNothing() throws Exception {
        throw new Exception("error especifico ");
    }


    @Test(expected = Exception.class)
    public void testDoNothing() throws Exception {

        ExcHandling excHandling = new ExcHandling();

        excHandling.doNothing();
    }


    @Test
    public void testDoNothing2() {
        ExcHandling excHandling = new ExcHandling();

        try {
            excHandling.doNothing();
            fail("Must Throw WapiException ");
        }catch (Exception e){
            Assert.assertEquals("error especifico ",e.getMessage());
        }
    }
}
