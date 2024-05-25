package ramanda.ajisaka.asyraf.spring.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ramanda.ajisaka.asyraf.spring.mvc.model.CreatePersonRequest;
import ramanda.ajisaka.asyraf.spring.mvc.model.CreateSocialMediaRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testJson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Ramanda");
        request.setMiddleName("Ajisaka");
        request.setLastName("Asyraf");
        request.setEmail("rama@example.com");
        request.setPhone("08213123");
        request.setHobbies(List.of("Coding", "Reading", "Gaming"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "facebook.com/oke"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com/oke"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
          status().isOk(),
          content().string(Matchers.containsString(jsonRequest))
        );
    }

    @Test
    public void testJsonInvalid() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddleName("Ajisaka");
        request.setLastName("Asyraf");
        request.setHobbies(List.of("Coding", "Reading", "Gaming"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "facebook.com/oke"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com/oke"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}
