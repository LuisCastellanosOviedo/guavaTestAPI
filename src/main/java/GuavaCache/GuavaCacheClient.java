package GuavaCache;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class GuavaCacheClient {



    public void useCache() throws ExecutionException {
        List<TradeAccount> tradeAccounts  = GuavaCache.ReadAndFormatData("1");
        tradeAccounts.stream().forEach(a -> a.setBalance(55));
        tradeAccounts.add(TradeAccount.builder().build());
        List<TradeAccount> tradeAccounts1  = GuavaCache.ReadData("1");
    }
}
