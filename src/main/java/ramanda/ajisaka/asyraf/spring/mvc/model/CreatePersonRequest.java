package ramanda.ajisaka.asyraf.spring.mvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private CreateAddressRequest address;

    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;

    @NotBlank
    private String phone;
    @NotBlank
    private String email;

    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedias;
}
