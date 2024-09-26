package stmallsoyun.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmallsoyun.domain.*;

@Component
public class IventoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Iventory>> {

    @Override
    public EntityModel<Iventory> process(EntityModel<Iventory> model) {
        return model;
    }
}
