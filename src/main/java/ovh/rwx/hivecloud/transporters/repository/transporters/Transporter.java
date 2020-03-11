package ovh.rwx.hivecloud.transporters.repository.transporters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Table("transporters")
@Schema(
        name = "Transporter",
        description = "Data object for a Transporter"
)
public class Transporter {
    @Id
    private Long id;
    @NotEmpty(message = "Please provide a name")
    private String name;
    @NotEmpty(message = "Please provide a CNPJ")
    private String cnpj;
    @NotEmpty(message = "Please provide a company name")
    @Size(min = 4)
    private String company;
    @NotEmpty(message = "Please provide an e-mail")
    @Email
    private String email;
    @NotEmpty(message = "Please provide a phone number")
    private String phoneNumber;
    private String mobileNumber;
    private String whatsappNumber;
    @NotEmpty(message = "Please provide a modal")
    private String[] modal;
    @NotEmpty(message = "Please provide a CEP")
    @Size(min = 9, max = 9)
    private String cep;
    @NotEmpty(message = "Please provide a city")
    private String city;
    @NotEmpty(message = "Please provide a district")
    private String district;
    @NotEmpty(message = "Please provide a street")
    private String street;
    @NotEmpty(message = "Please provide a street number")
    private String streetNumber;
    @NotEmpty(message = "Please provide a company logo")
    private byte[] companyLogo;
}
