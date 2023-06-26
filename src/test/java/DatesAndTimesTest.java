import Skills.DatesAndTimes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@DisplayName("DatesAndTimes class should")
public class DatesAndTimesTest {

    private final DatesAndTimes datesAndTimes = new DatesAndTimes();

    private String schedule;

    @BeforeEach
    void setUp() {
        schedule = """
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
    }

    @Test
    @DisplayName("calculate correctly the greatest available gap of time between events.")
    void calculateGreatestGap() {
        Duration gap = datesAndTimes.calculateGreatestGap(schedule);
        Assertions.assertEquals(Duration.ofMinutes(505), gap);
    }
}
