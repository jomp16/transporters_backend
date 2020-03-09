package ovh.rwx.hivecloud.transporters.services.cep.viacep;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ovh.rwx.hivecloud.transporters.services.cep.CepResponse;
import ovh.rwx.hivecloud.transporters.services.cep.CepService;
import reactor.core.publisher.Mono;

@Service
public class ViaCepService implements CepService {
    private static final String URL = "https://viacep.com.br/ws/%s/json/";

    @Override
    public Mono<CepResponse> locateCep(String cep) {
        WebClient webClient = WebClient.create();

        return webClient.get()
                .uri(String.format(URL, cep.replace("-", "")))
                .retrieve()
                .bodyToMono(CepResponse.class);
    }
}
