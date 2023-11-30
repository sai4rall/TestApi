import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateTimeParser {
    public static void main(String[] args) {
        String dateString = "2022-10-29T21:37:22.444+530";

        // Define a custom DateTimeFormatter
        DateTimeFormatter customFormatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .appendOffset("+HHmm", "+0000")
                .toFormatter();

        // Parse the string into LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, customFormatter);

        // Parse the string into ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, customFormatter);

        // Print the results
        System.out.println("Parsed LocalDateTime: " + localDateTime);
        System.out.println("Parsed ZonedDateTime: " + zonedDateTime);
    }
}
