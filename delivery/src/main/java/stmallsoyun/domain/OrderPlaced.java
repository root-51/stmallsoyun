package stmallsoyun.domain;

import java.util.*;
import lombok.*;
import stmallsoyun.domain.*;
import stmallsoyun.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private Integer status;
}
