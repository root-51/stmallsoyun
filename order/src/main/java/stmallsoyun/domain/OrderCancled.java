package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private Integer status;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private Integer status;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private Integer status;

    public OrderCancled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancled() {
        super();
    }
}
//>>> DDD / Domain Event
