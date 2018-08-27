package GuavaCache;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class GuavaCacheTest {


    @Test
    public void testVer1() throws ExecutionException {


        TradeAccount tradeAccount1 = GuavaCache.getCacheVer1().get("1");
        TradeAccount tradeAccount2 = GuavaCache.getCacheVer1().get("1");
        TradeAccount tradeAccount3 = GuavaCache.getCacheVer1().get("2");


        Assert.assertThat(tradeAccount1.getId(), Is.is("1"));

        Assert.assertNotNull(tradeAccount1);
        Assert.assertNotNull(tradeAccount2);
        Assert.assertNotNull(tradeAccount3);
    }

    @Test
    public void testVer2() throws ExecutionException {


        TradeAccount tradeAccount1 = GuavaCache.getCacheVer2().get("1");
        TradeAccount tradeAccount2 = GuavaCache.getCacheVer2().get("1");
        TradeAccount tradeAccount3 = GuavaCache.getCacheVer2().get("2");


        Assert.assertThat(tradeAccount3.getId(), Is.is("2"));

        Assert.assertNotNull(tradeAccount1);
        Assert.assertNotNull(tradeAccount2);
        Assert.assertNotNull(tradeAccount3);
    }


    @Test
    public void testVer3() throws ExecutionException {


        TradeAccount tradeAccount1 = GuavaCache.getCacheVer3().get("1");
        TradeAccount tradeAccount2 = GuavaCache.getCacheVer3().get("1");
        TradeAccount tradeAccount4 = GuavaCache.getCacheVer3().get("1");
        TradeAccount tradeAccount3 = GuavaCache.getCacheVer3().get("2");


        Assert.assertThat(tradeAccount3.getId(), Is.is("2"));

        Assert.assertNotNull(tradeAccount1);
        Assert.assertNotNull(tradeAccount2);
        Assert.assertNotNull(tradeAccount3);
        Assert.assertNotNull(tradeAccount4);
    }
}
