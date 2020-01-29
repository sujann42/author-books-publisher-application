package suzan.repositories;

import org.springframework.data.repository.CrudRepository;
import suzan.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
