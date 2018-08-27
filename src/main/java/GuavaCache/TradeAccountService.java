package GuavaCache;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TradeAccountService {

    private List<TradeAccount> tradeAccounts  = Arrays.asList(TradeAccount.builder().id("1").build(),
            TradeAccount.builder().id("2").build());

    public TradeAccount GettradeAccountById(String id ){
        return tradeAccounts.stream().filter(a -> a.getId().equals(id)).collect(Collectors.toList()).iterator().next();
    }


}
