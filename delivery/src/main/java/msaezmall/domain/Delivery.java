package msaezmall.domain;

import msaezmall.domain.DeliveryStarted;
import msaezmall.domain.DeliveryCompleted;
import msaezmall.domain.DeliveryReturned;
import msaezmall.domain.DeliveryCancelled;
import msaezmall.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();



        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        deliveryCancelled.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void startDelivery(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void cancelDelivery(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
