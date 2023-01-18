package msaezmall.domain;

import msaezmall.domain.*;
import msaezmall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productImage;
    private Integer stock;

    public StockIncreased(Inventory aggregate){
        super(aggregate);
    }
    public StockIncreased(){
        super();
    }
}
