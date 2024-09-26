package stmallsoyun.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallsoyun.config.kafka.KafkaProcessor;
import stmallsoyun.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    IventoryRepository iventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_DecreaseStock(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener DecreaseStock : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Iventory.decreaseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliveryreturned'"
    )
    public void wheneverDeliveryreturned_IncreaseStock(
        @Payload Deliveryreturned deliveryreturned
    ) {
        Deliveryreturned event = deliveryreturned;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + deliveryreturned + "\n\n"
        );

        // Sample Logic //
        Iventory.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
