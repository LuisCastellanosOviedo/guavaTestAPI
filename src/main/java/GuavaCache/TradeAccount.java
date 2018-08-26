package GuavaCache;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TradeAccount {

    private String id;
    private String owner;
    private double balance;

}
