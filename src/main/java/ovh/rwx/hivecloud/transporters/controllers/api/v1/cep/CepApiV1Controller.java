package ovh.rwx.hivecloud.transporters.controllers.api.v1.cep;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.rwx.hivecloud.transporters.services.cep.CepResponse;
import ovh.rwx.hivecloud.transporters.services.cep.CepService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cep")
@ResponseBody
public class CepApiV1Controller {
    private final CepService cepService;

    public CepApiV1Controller(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping(value = "/locate/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get the CEP information",
            description = "Use this endpoint to get the CEP information in the backend",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public Mono<CepResponse> locateCep(@PathVariable String cep) {
        return this.cepService.locateCep(cep);
    }
}
