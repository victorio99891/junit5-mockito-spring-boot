package pl.wiktor.testservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.testservice.service.TestService;

import java.util.List;

@Slf4j
@RestController
public class TestController {


    private TestService service;

    @Autowired
    public TestController(TestService testService) {
        this.service = testService;
    }

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<String> getTestResponse() {
        log.debug("Test controller!");
        return ResponseEntity.ok("Hello world!");
    }

    @GetMapping("/elements")
    @ResponseBody
    public ResponseEntity<List<String>> getAllElements() {
        log.debug("GetAll!");
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/elements/{id}")
    @ResponseBody
    public ResponseEntity<String> getByIndex(@PathVariable("id") int index) {
        log.debug("Index param: " + index);
        return ResponseEntity.ok(service.getByIndex(index));
    }

    @GetMapping("/element")
    @ResponseBody
    public ResponseEntity<String> getByIndex(@RequestParam(required = false, name = "content") String content) {
        log.debug("Content param: " + content);
        if (content == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.getByContent(content));
    }

}
