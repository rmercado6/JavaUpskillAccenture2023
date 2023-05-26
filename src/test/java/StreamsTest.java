import Model.Person;
import Skills.Streams;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    private Streams streams;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        streams = new Streams(null);
    }

    @org.junit.jupiter.api.Test
    void howManyPeopleWhoLiveInMexico() {
        long howMany = streams.howManyPeopleWhoLiveInMexico();
        assertEquals(6, howMany);
    }

    @org.junit.jupiter.api.Test
    void peopleWhoLiveInMexico() {
    }

    @org.junit.jupiter.api.Test
    void howManyLiveByCountry() {
    }
}