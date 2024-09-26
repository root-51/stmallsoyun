package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;

    public DeliveryCompleted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
