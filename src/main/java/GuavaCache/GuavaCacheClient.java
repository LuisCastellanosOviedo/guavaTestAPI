package GuavaCache;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class GuavaCacheClient {



    public void useCache() throws ExecutionException {
        List<TradeAccount> tradeAccounts  = GuavaCache.ReadData("1");
        tradeAccounts.stream().forEach(a -> a.setBalance(55));
        List<TradeAccount> tradeAccounts1  = GuavaCache.FormatData("1");
    }
}
