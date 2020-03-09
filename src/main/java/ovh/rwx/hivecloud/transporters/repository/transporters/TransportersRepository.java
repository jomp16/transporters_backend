package ovh.rwx.hivecloud.transporters.repository.transporters;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportersRepository extends ReactiveCrudRepository<Transporter, Long> {
}
