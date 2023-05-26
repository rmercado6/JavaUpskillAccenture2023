import Model.Person;
import Skills.Streams;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

@DisplayName("Streams class should")
class StreamsTest {

    private final Streams streams = new Streams();

    private List<Person> people;

    @BeforeEach
    void setUp() {
        people = List.of(
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
    }


    @Test
    @DisplayName("filter and calculate correctly the amount of people who live in mexico.")
    void howManyPeopleWhoLiveInMexico() {
        long actual = streams.howManyPeopleWhoLiveInMexico(people);
        Assertions.assertEquals(6, actual);
    }

    @Test
    @DisplayName("filter correctly the list of people who live in mexico.")
    void peopleWhoLiveInMexico() {
        List<Person> expected = people.stream().filter(p -> p.getCountry().equals("MX")).toList();
        List<Person> actual = streams.peopleWhoLiveInMexico(people);
        Assertions.assertTrue(actual.containsAll(expected));
    }

    @Test
    @DisplayName("return a map that indicates the correct calculation of how many live in each country available in the list.")
    void howManyLiveByCountry() {
        Map<String, Long> expected = Map.of(
                "USA", 4L,
                "MX", 6L
        );
        Map<String, Long> actual = streams.howManyLiveByCountry(people);
        MatcherAssert.assertThat(actual, is(expected));
    }
}