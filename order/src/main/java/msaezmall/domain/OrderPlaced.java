package msaezmall.domain;

import msaezmall.domain.*;
import msaezmall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private String productName;
    private String status;
    private Integer qty;
    private String address;

    public OrderPlaced(Order aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}
