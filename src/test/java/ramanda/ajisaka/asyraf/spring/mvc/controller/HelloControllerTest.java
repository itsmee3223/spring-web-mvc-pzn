package ramanda.ajisaka.asyraf.spring.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testHelloGuest() throws Exception {
        mockMvc.perform(get("/hello")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest"))
        );
    }

    @Test
    void testHelloRamanda() throws Exception {
        mockMvc.perform(
                get("/hello").param("name", "Ramanda")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Ramanda"))
        );
    }

    @Test
    void testPost() throws Exception {
        mockMvc.perform(
                post("/hello").param("name", "Ramanda")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }

    @Test
    void helloView() throws Exception {
        mockMvc.perform(
                get("/web/hello").queryParam("name", "Ramanda")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Belajar View")),
                content().string(Matchers.containsString("Hello Ramanda"))
        );
    }

}