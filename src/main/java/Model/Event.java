package Model;

import lombok.Getter;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@ToString
public class Event {

    @Getter
    private LocalDateTime beginning;

    @Getter
    private LocalDateTime ending;

    public Event(String timeString) {
        String day = timeString.split(" ")[0];
        String beginning = timeString.split(" ")[1].split("-")[0];
        String ending = timeString.split(" ")[1].split("-")[1];

        String beginningDateTimeString = day + " " + beginning;
        String endingDateTimeString = day + " " + ending;

        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("E HH:mm")
                .parseDefaulting(ChronoField.YEAR, LocalDateTime.now().getYear())
                .parseDefaulting(ChronoField.ALIGNED_WEEK_OF_YEAR, LocalDateTime.now().get(ChronoField.ALIGNED_WEEK_OF_YEAR))
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        LocalDateTime beginningDateTime = LocalDateTime.parse(beginningDateTimeString, format);
        LocalDateTime endingDateTime = LocalDateTime.parse(endingDateTimeString, format);

//        System.out.println(beginningDateTime + " - " + endingDateTime);
        if (endingDateTime.isBefore(beginningDateTime)){
            throw new DateTimeException("Invalid dates.");
        }
        this.beginning = beginningDateTime;
        this.ending = endingDateTime;
    }


}
