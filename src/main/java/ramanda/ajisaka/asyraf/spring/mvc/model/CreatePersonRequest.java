package ramanda.ajisaka.asyraf.spring.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private CreateAddressRequest address;

    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String email;

    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedias;
}
