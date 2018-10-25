package GuavaCache;

import com.google.common.base.Function;
import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCache {

    private static TradeAccountService tradeAccountService = new TradeAccountService();

    private static LoadingCache<String,TradeAccount> tradeAccountCache;
    private static LoadingCache<String,TradeAccount> tradeAccountCacheVer2;
    private static LoadingCache<String,TradeAccount> tradeAccountCacheVer3;
    private static LoadingCache<String,List<TradeAccount>> tradeAccountCacheVer4;


    public synchronized static LoadingCache<String,TradeAccount>  getCacheVer1(){
        if(tradeAccountCache == null){
            createCacheVer1Size();
        }

        return tradeAccountCache;
    }
    public synchronized static LoadingCache<String,TradeAccount>  getCacheVer2(){
        if(tradeAccountCacheVer2 == null){
            createCacheVer2NoSize();
        }

        return tradeAccountCacheVer2;
    }

    public  static LoadingCache<String,TradeAccount>  getCacheVer3(){
        if(tradeAccountCacheVer3 == null){
            createCacheVer3();
        }

        return tradeAccountCacheVer3;
    }







    private  static  LoadingCache<String,List<TradeAccount>>  getCacheVer4(){
        if(tradeAccountCacheVer4 == null){
            createCacheVer4();
        }

        return tradeAccountCacheVer4;
    }

    public static List<TradeAccount> ReadData(String id) throws ExecutionException {
        return getCacheVer4().get(id);


    }
    public static List<TradeAccount> ReadAndFormatData(String id) throws ExecutionException {


        return Lists.transform(getCacheVer4().get(id),new Function<TradeAccount,
                TradeAccount>() {
            @Override
            public TradeAccount apply(TradeAccount input) {
                return input.toBuilder().build();
            }
        });
    }


    public static void  purgeCache( ) throws ExecutionException {
         getCacheVer4().cleanUp();
    }


    private static void createCacheVer4() {
        tradeAccountCacheVer4 = CacheBuilder.newBuilder()
                .expireAfterWrite(1L,TimeUnit.DAYS)
                .build(new CacheLoader<String, List<TradeAccount>>() {
                    @Override
                    public List<TradeAccount> load(String key) throws Exception {
                        return    tradeAccountService.getTradeAccounts();
                    }
                });

    }







    private static  void createCacheVer1Size() {
        tradeAccountCache = CacheBuilder.newBuilder()
                .expireAfterWrite(5L, TimeUnit.MINUTES)
                .maximumSize(5000L)
                .ticker(Ticker.systemTicker())
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
                        return    tradeAccountService.GettradeAccountById(key);
                    }
                });
    }

    private static  void createCacheVer2NoSize(){
        tradeAccountCacheVer2 = CacheBuilder.newBuilder()
                .expireAfterAccess(20L,TimeUnit.MINUTES)
                .softValues()
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
                        return    tradeAccountService.GettradeAccountById(key);
                    }
                });
    }
    private static  void createCacheVer3(){
        tradeAccountCacheVer3 = CacheBuilder.newBuilder()
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .refreshAfterWrite(1L,TimeUnit.MINUTES)
                .ticker(Ticker.systemTicker())
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
                        return    tradeAccountService.GettradeAccountById(key);
                    }
                });

    }

}
