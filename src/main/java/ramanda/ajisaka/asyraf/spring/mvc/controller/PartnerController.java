package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ramanda.ajisaka.asyraf.spring.mvc.model.Partner;

@Controller
public class PartnerController {

    @GetMapping(path = "/partner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPartner(Partner partner){
        return partner.getId() + ":" + partner.getName();
    }
}
