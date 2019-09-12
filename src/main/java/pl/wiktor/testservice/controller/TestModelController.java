package pl.wiktor.testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wiktor.testservice.model.TestModel;
import pl.wiktor.testservice.service.TestModelService;

import java.util.List;

@RestController
public class TestModelController {

    private TestModelService service;

    @Autowired
    public TestModelController(TestModelService service) {
        this.service = service;
    }

    @GetMapping("/models")
    public @ResponseBody
    ResponseEntity<List<TestModel>> getAll() {
        return ResponseEntity.ok(service.getAllModels());
    }


}
