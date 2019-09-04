package pl.wiktor.testservice.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestRepository {


    private List<String> stringList;

    @PostConstruct
    void initData() {
        stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
    }

    public List<String> getAll() {
        return stringList;
    }

    public String getOneByIndex(int id) {
        if (id < stringList.size()) {
            return stringList.get(id);
        } else {
            return null;
        }
    }

    public String getByContent(String content) {
        if (stringList.contains(content)) {
            return stringList.get(stringList.indexOf(content));
        } else {
            return null;
        }

    }


}
