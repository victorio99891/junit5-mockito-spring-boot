package pl.wiktor.testservice.repository;

import org.springframework.stereotype.Repository;
import pl.wiktor.testservice.model.CategoryTypeTest;
import pl.wiktor.testservice.model.TestModel;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestModelRepository {


    private List<TestModel> modelList = new ArrayList<>();

    @PostConstruct
    void init() {
        modelList.add(TestModel.builder()
                .id(1)
                .name("Screen Protector")
                .price(new BigDecimal(12.99))
                .type(CategoryTypeTest.NORMAL)
                .build());
        modelList.add(TestModel.builder()
                .id(2)
                .name("Keyboard")
                .price(new BigDecimal(9.99))
                .type(CategoryTypeTest.DISCOUNT)
                .build());
        modelList.add(TestModel.builder()
                .id(3)
                .name("Gaming Headset")
                .price(new BigDecimal(15.99))
                .type(CategoryTypeTest.PERMANENT_DISCOUNT)
                .build());
    }

    public List<TestModel> getAllModels() {
        return modelList;
    }
}
