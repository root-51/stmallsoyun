package stmallsoyun.domain;

import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;
}
