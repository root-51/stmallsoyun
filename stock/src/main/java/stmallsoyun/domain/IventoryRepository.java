package stmallsoyun.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmallsoyun.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "iventories",
    path = "iventories"
)
public interface IventoryRepository
    extends PagingAndSortingRepository<Iventory, Long> {}
