package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ramanda.ajisaka.asyraf.spring.mvc.model.CreatePersonRequest;

@Controller
public class PersonApiController {

    @PostMapping(
            path = "/api/person",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public CreatePersonRequest createPerson(
            @RequestBody CreatePersonRequest request
    ){
        return request;
    }
}
