package msaezmall.domain;

import msaezmall.domain.*;
import msaezmall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String productId;
    private String productName;
    private String address;
    private String status;
}


