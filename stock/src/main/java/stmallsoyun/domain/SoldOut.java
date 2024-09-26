package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SoldOut extends AbstractEvent {

    private Long id;

    public SoldOut(Iventory aggregate) {
        super(aggregate);
    }

    public SoldOut() {
        super();
    }
}
//>>> DDD / Domain Event
