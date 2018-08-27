package GuavaCache;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class GuavaCacheClientTest {

    private GuavaCacheClient guavaCacheClient;


    @Before
    public void setUp() throws Exception {
        guavaCacheClient = new GuavaCacheClient();
    }

    @Test
    public void testClient() throws ExecutionException {
       guavaCacheClient.useCache();
    }
}
