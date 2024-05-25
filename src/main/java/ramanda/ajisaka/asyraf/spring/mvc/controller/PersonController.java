package ramanda.ajisaka.asyraf.spring.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ramanda.ajisaka.asyraf.spring.mvc.model.CreatePersonRequest;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson(
            @ModelAttribute @Valid CreatePersonRequest request
            ){
        System.out.println(request);

        return "Success create person " +
                request.getFirstName() + " " +
                request.getMiddleName() + " " +
                request.getLastName() + " " +
                "with email " + request.getEmail() + " " +
                "and phone " + request.getPhone() +
                " with address " +
                request.getAddress().getStreet() + ", " +
                request.getAddress().getCity() + ", " +
                request.getAddress().getCountry() + ", " +
                request.getAddress().getPostalCode();
    }
}
