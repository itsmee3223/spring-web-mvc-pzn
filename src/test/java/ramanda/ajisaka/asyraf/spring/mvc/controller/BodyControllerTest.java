package ramanda.ajisaka.asyraf.spring.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ramanda.ajisaka.asyraf.spring.mvc.model.HelloRequest;
import ramanda.ajisaka.asyraf.spring.mvc.model.HelloResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BodyControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void bodHello() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Ramanda");

        mockMvc.perform(
                post("/body/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andExpect(result -> {
            String bodyResponse = result.getResponse().getContentAsString();
            HelloResponse response = objectMapper.readValue(bodyResponse, HelloResponse.class);
            Assertions.assertEquals("Hello Ramanda", response.getHello());
        });
    }

}