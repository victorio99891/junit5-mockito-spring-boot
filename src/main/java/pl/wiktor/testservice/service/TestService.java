package pl.wiktor.testservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiktor.testservice.repository.TestRepository;

import java.util.List;

@Service
public class TestService {


    private TestRepository repository;

    @Autowired
    public TestService(TestRepository repository) {
        this.repository = repository;
    }


    public List<String> getAll() {
        return repository.getAll();
    }

    public String getByIndex(int index) {
        return repository.getOneByIndex(index);
    }

    public String getByContent(String content) {
        return repository.getByContent(content);
    }


}
