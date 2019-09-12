package pl.wiktor.testservice.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestModel {

    private int id;
    private String name;
    private BigDecimal price;
    private CategoryTypeTest type;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestModel)) return false;
        TestModel testModel = (TestModel) o;
        return getId() == testModel.getId() &&
                Objects.equals(getName(), testModel.getName()) &&
                Objects.equals(getPrice(), testModel.getPrice()) &&
                getType() == testModel.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getType());
    }
}
