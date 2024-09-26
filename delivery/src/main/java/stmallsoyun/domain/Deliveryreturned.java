package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Deliveryreturned extends AbstractEvent {

    private Long id;

    public Deliveryreturned(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveryreturned() {
        super();
    }
}
//>>> DDD / Domain Event
