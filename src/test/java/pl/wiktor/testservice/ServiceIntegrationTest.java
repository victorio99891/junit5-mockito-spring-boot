package pl.wiktor.testservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wiktor.testservice.service.TestService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class ServiceIntegrationTest {

    private TestService testService;

    private static final String EXISTING_ELEMENT = "A";

    @Autowired
    public ServiceIntegrationTest(TestService testService) {
        this.testService = testService;
    }

    @Test
    void shouldGetAllReturnListWithMoreThanZeroElements() {
        log.info("shouldGetAllReturnListWithMoreThanZeroElements");
        assertTrue(testService.getAll().size() > 0, "Returned list should contains more than 0 elements.");
    }

    @Test
    void shouldGetByIndexReturnElement() {
        log.info("shouldGetByIndexReturnElement");
        assertEquals(EXISTING_ELEMENT, testService.getByIndex(0), "Returned element should be equal to " + EXISTING_ELEMENT);
    }

    @Test
    void shouldGetByIndexReturnNull() {
        log.info("shouldGetByIndexReturnNull");
        assertNull(testService.getByIndex(999999), "Returned element should be null");
    }

    @Test
    void shouldGetByContentReturnElement() {
        log.info("shouldGetByContentReturnElement");
        assertEquals(EXISTING_ELEMENT, testService.getByContent(EXISTING_ELEMENT), "Returned element should be equal to " + EXISTING_ELEMENT);
    }

    @Test
    void shouldGetByContentReturnNull() {
        log.info("shouldGetByContentReturnNull");
        assertNull(testService.getByContent(EXISTING_ELEMENT + "A"), "Returned element should be null");
    }


}
