package pl.wiktor.testservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.wiktor.testservice.service.TestService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class ServiceTest {

    @Mock
    public TestService testService;


    private static final String TEST1 = "TEST1";
    private static final String TEST2 = "TEST2";
    private static final List<String> mockedList = new ArrayList<>();


    @BeforeAll
    static void init() {
        mockedList.add(TEST1);
        mockedList.add(TEST2);
    }


    @Test
    void shouldGetAllReturnListWithMoreThanZeroElements() {
        log.info("shouldGetAllReturnListWithMoreThanZeroElements");
        when(testService.getAll()).thenReturn(mockedList);
        assertTrue(testService.getAll().size() > 0, "Returned list should contains more than 0 elements.");
    }

    @Test
    void shouldGetByIndexReturnElement() {
        log.info("shouldGetByIndexReturnElement");
        when(testService.getByIndex(anyInt())).thenReturn(TEST1);
        assertEquals(TEST1, testService.getByIndex(0), "Returned element should be equal to " + TEST1);
    }

    @Test
    void shouldGetByIndexReturnNull() {
        log.info("shouldGetByIndexReturnNull");
        when(testService.getByIndex(anyInt())).thenReturn(null);
        assertNull(testService.getByIndex(0), "Returned element should be null");
    }

    @Test
    void shouldGetByContentReturnElement() {
        log.info("shouldGetByContentReturnElement");
        when(testService.getByContent(anyString())).thenReturn(TEST1);
        assertEquals(TEST1, testService.getByContent(TEST1), "Returned element should be equal to " + TEST1);
    }

    @Test
    void shouldGetByContentReturnNull() {
        log.info("shouldGetByContentReturnNull");
        when(testService.getByContent(anyString())).thenReturn(null);
        assertNull(testService.getByContent(TEST1), "Returned element should be null");
    }

}
