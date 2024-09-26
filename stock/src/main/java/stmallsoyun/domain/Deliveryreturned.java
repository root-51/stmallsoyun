package stmallsoyun.domain;

import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

@Data
@ToString
public class Deliveryreturned extends AbstractEvent {

    private Long id;
}
