import Model.Person;

import java.util.List;
import Skills.Streams;

public class Main {
    public static void main(String[] args) {

        // Define lista de personas original con las que se trabajará
        List<Person> people = List.of(
                new Person("Juan", 26, "MX"),
                new Person("Shaun", 35, "USA"),
                new Person("Miguel", 26, "MX"),
                new Person("Pedro", 26, "MX"),
                new Person("Chris", 26, "USA"),
                new Person("Félix", 26, "USA"),
                new Person("Pablo", 26, "MX"),
                new Person("Daniel", 26, "USA"),
                new Person("Rodolfo", 26, "MX"),
                new Person("Héctor", 26, "MX")
        );

        Streams streams = new Streams(people);
        streams.run();

    }
}