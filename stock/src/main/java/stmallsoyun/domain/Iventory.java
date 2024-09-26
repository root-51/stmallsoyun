package stmallsoyun.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmallsoyun.StockApplication;
import stmallsoyun.domain.SoldOut;
import stmallsoyun.domain.StockDecreased;

@Entity
@Table(name = "Iventory_table")
@Data
//<<< DDD / Aggregate Root
public class Iventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String stock;

    @PostPersist
    public void onPostPersist() {
        SoldOut soldOut = new SoldOut(this);
        soldOut.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();
    }

    public static IventoryRepository repository() {
        IventoryRepository iventoryRepository = StockApplication.applicationContext.getBean(
            IventoryRepository.class
        );
        return iventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Iventory iventory = new Iventory();
        repository().save(iventory);

        SoldOut soldOut = new SoldOut(iventory);
        soldOut.publishAfterCommit();
        StockDecreased stockDecreased = new StockDecreased(iventory);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(iventory->{
            
            iventory // do something
            repository().save(iventory);

            SoldOut soldOut = new SoldOut(iventory);
            soldOut.publishAfterCommit();
            StockDecreased stockDecreased = new StockDecreased(iventory);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(Deliveryreturned deliveryreturned) {
        //implement business logic here:

        /** Example 1:  new item 
        Iventory iventory = new Iventory();
        repository().save(iventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryreturned.get???()).ifPresent(iventory->{
            
            iventory // do something
            repository().save(iventory);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
