package ovh.rwx.hivecloud.transporters.services.transporters;

import org.springframework.stereotype.Service;
import ovh.rwx.hivecloud.transporters.repository.transporters.Transporter;
import ovh.rwx.hivecloud.transporters.repository.transporters.TransportersRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransportersService {
    private TransportersRepository transportersRepository;

    public TransportersService(TransportersRepository transportersRepository) {
        this.transportersRepository = transportersRepository;
    }

    public Flux<Transporter> listTransporters() {
        return this.transportersRepository.findAll();
    }

    public Mono<Transporter> getTransporter(long transporterId) {
        return this.transportersRepository.findById(transporterId);
    }

    public Mono<Transporter> addTransporter(Transporter transporter) {
        return this.transportersRepository.save(transporter);
    }

    public Mono<Transporter> updateTransporter(Transporter transporter) {
        return this.transportersRepository.save(transporter);
    }

    public void deleteTransporter(long transporterId) {
        this.transportersRepository.deleteById(transporterId);
    }
}
