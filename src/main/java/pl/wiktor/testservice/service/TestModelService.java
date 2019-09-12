package pl.wiktor.testservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiktor.testservice.model.TestModel;
import pl.wiktor.testservice.repository.TestModelRepository;

import java.util.List;

@Service
public class TestModelService {

    private TestModelRepository repository;

    @Autowired
    public TestModelService(TestModelRepository repository) {
        this.repository = repository;
    }


    public List<TestModel> getAllModels() {
        return repository.getAllModels();
    }
}
