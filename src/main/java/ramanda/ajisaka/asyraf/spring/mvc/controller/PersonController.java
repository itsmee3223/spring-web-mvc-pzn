package ramanda.ajisaka.asyraf.spring.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ramanda.ajisaka.asyraf.spring.mvc.model.CreatePersonRequest;

import java.util.List;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseEntity<String> createPerson(
            @ModelAttribute @Valid CreatePersonRequest request,
            BindingResult bindingresult
            ){

        if(!bindingresult.getAllErrors().isEmpty()){
            List<FieldError> fieldErrors = bindingresult.getFieldErrors();
            fieldErrors.forEach(error -> {
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            });

            return ResponseEntity.badRequest().body("You send invalid data");
        }

        System.out.println(request);

        String response = "Success create person " +
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

        return ResponseEntity.ok().body(response);
    }
}
