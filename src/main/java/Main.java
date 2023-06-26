import Model.Person;
import Skills.DatesAndTimes;
import Skills.Streams;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // STREAMS
        System.out.println("\n\t---\tSTREANS\t---\n");

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

        Streams streams = new Streams();
        streams.run(people);

        // DATE AND TIME
        System.out.println("\n\t---\tDATE AND TIME\t---\n");

        // Define la agenda de eventos con la que se trabajará
        String schedule = """
            Sun 10:00-20:00
            Fri 05:00-10:00
            Fri 16:30-23:50
            Sat 10:00-24:00
            Sun 01:00-04:00
            Sat 02:00-06:00
            Tue 03:30-18:15
            Tue 19:00-20:00
            Wed 04:25-15:14
            Wed 15:14-22:40
            Thu 00:00-23:59
            Mon 05:00-13:00
            Mon 15:00-21:00""";

        DatesAndTimes datesAndTimes = new DatesAndTimes();
        datesAndTimes.run(schedule);

    }
}