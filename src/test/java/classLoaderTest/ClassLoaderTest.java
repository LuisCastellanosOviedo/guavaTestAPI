package classLoaderTest;

import classLoaderPOC.ClassLoaderPOC;
import org.junit.Assert;
import org.junit.Test;

public class ClassLoaderTest {

    @Test
    public void TestInstanceExist() {
        Assert.assertNotNull(ClassLoaderPOC.getInstance());
    }
}
