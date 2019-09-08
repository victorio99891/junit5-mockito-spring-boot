package pl.wiktor.testservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.wiktor.testservice.controller.TestController;
import pl.wiktor.testservice.service.TestService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(TestController.class)
class ControllerIntegrationTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private TestService service;

    @Test
    void shouldReturnTestHelloWorldMessageWithOkStatus() throws Exception {
        log.info("shouldReturnTestHelloWorldMessageWithOkStatus");
        MvcResult result = mvc.perform(get("/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Hello world!"))
                .andReturn();

        assertEquals("text/plain;charset=UTF-8",
                result.getResponse().getContentType());
    }

    @Test
    void shouldReturnListOfString() throws Exception {
        log.info("shouldReturnListOfString");
        List<String> testList = new ArrayList<>();
        testList.add("TEST");
        when(service.getAll()).thenReturn(testList);
        MvcResult result = mvc.perform(get("/elements"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
