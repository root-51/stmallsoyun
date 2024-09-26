package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmallsoyun.OrderApplication;
import stmallsoyun.domain.OrderCancled;
import stmallsoyun.domain.OrderModified;
import stmallsoyun.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String productName;

    private Long productId;

    private Integer qty;

    private Integer status;

    @Embedded
    private OrderItems orderItems;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderModified orderModified = new OrderModified(this);
        orderModified.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void order() {
        //implement business logic here:

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public void modify() {
        //implement business logic here:

        OrderModified orderModified = new OrderModified(this);
        orderModified.publishAfterCommit();
    }

    public void cancle() {
        //implement business logic here:

        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(DeliveryCompleted deliveryCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
