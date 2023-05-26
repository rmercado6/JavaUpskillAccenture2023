package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Person {

    @Getter
    private String name;

    @Getter
    private int age;

    @Getter
    private String country;

}
