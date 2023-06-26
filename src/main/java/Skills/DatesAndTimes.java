package Skills;

import Model.Event;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DatesAndTimes {

    public void run (String schedule) {
        Duration gap = calculateGreatestGap(schedule);
        assert gap != null;
        System.out.println("El tiempo más grande para dormir es de " + gap.toMinutes() + " minutos.");
    }

    public Duration calculateGreatestGap(String schedule){
        // Build event objects
        List<Event> events = new ArrayList<>(Arrays.stream(schedule.split("\\r?\\n"))
                .map(Event::new)
                .toList());

        // beginning of week
        events.add(new Event("Mon 00:00-00:00"));

        // end of week
        events.add(new Event("Sun 24:00-24:00"));

        // order events by ascending order of beginningDate
        events.sort(Comparator.comparing(Event::getBeginning));

        // Calculate the greatest Gap between events
        Duration gap = Duration.ZERO;
        for(int i = 0; i < events.size() - 1; i++){
            LocalDateTime currentEvent = events.get(i).getEnding();
            LocalDateTime nextEvent = events.get(i + 1).getBeginning();

            // calculate gap between current index ending with next index beginning
            Duration calculatedGap = Duration.between(currentEvent, nextEvent);

            // if gap is greater, then substitute current greatest calculated gap
            if (calculatedGap.compareTo(gap) > 0){
                gap = calculatedGap;
            }
        }

        return gap;
    }

}
