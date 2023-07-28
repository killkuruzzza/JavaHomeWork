package employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class SuperEmployees {
    private String name;
    private String family;

    public abstract double getSalary();
}