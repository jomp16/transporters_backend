package ovh.rwx.hivecloud.transporters.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Component;

@Component
@OpenAPIDefinition(
        info = @Info(
                title = "Transporters",
                version = "0.0.1",
                description = "An API for Transporters",
                contact = @Contact(url = "https://github.com/jomp16", name = "José Olívio da Mota Pedrosa", email = "root@rwx.ovh")
        ),
        servers = {
                @Server(
                        description = "The main server",
                        url = "https://transporters.rwx.ovh"
                )
        }
)
public class SwaggerInfo {
}
