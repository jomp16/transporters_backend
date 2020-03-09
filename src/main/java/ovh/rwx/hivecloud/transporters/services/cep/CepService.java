package ovh.rwx.hivecloud.transporters.services.cep;

import reactor.core.publisher.Mono;

public interface CepService {
    Mono<CepResponse> locateCep(String cep);
}
