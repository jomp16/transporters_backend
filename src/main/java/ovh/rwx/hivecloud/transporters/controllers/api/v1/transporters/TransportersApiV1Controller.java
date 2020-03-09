package ovh.rwx.hivecloud.transporters.controllers.api.v1.transporters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ovh.rwx.hivecloud.transporters.repository.transporters.Transporter;
import ovh.rwx.hivecloud.transporters.repository.transporters.TransportersRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transporters")
@ResponseBody
public class TransportersApiV1Controller {
    private final TransportersRepository transportersRepository;

    public TransportersApiV1Controller(TransportersRepository transportersRepository) {
        this.transportersRepository = transportersRepository;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "List transporters",
            description = "Use this endpoint to list the transporters in the backend",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public Flux<Transporter> listTransporters() {
        return this.transportersRepository.findAll();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get a transporter by ID",
            description = "Use this endpoint to get a transporter by ID in the backend",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public Mono<Transporter> getTransporter(@PathVariable("id") long transporterId) {
        return this.transportersRepository.findById(transporterId);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new transporter",
            description = "Use this endpoint to create a new transporter in the backend",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public Mono<Transporter> add(@Valid @RequestBody Transporter transporter) {
        return this.transportersRepository.save(transporter);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Update a transporter",
            description = "Use this endpoint to update a transporter in the backend",
            parameters = {
                    @Parameter(name = "id", description = "The transporter ID", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public Mono<Transporter> update(@PathVariable("id") Long transporterId, @Valid @RequestBody Transporter transporter) {
        if (transporterId != null) {
            transporter.setId(transporterId);
        }

        return this.transportersRepository.save(transporter);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete a transporter",
            description = "Use this endpoint to delete a transporter in the backend",
            parameters = {
                    @Parameter(name = "id", description = "The transporter ID", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Server Error")
            }
    )
    public void delete(@PathVariable("id") long transporterId) {
        this.transportersRepository.deleteById(transporterId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        //Get all errors
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> Collections.singletonMap(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        body.put("errors", errors);

        return body;
    }
}
