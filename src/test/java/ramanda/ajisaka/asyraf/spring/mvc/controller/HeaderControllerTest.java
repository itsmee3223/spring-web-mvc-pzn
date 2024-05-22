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
class HeaderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testTokenOK() throws Exception {
        mockMvc.perform(
                get("/header/token")
                        .header("X-TOKEN", "Ramanda")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void testTokenKO() throws Exception {
        mockMvc.perform(
                get("/header/token")
                        .header("X-TOKEN", "Ajisaka")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("KO"))
        );
    }
}