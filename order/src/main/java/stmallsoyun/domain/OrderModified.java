package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderModified extends AbstractEvent {

    private Long id;

    public OrderModified(Order aggregate) {
        super(aggregate);
    }

    public OrderModified() {
        super();
    }
}
//>>> DDD / Domain Event
