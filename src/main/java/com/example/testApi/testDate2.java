
I apologize for the confusion. It seems I made an error in the previous example. Let me correct that for you.

java
Copy code
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    public static void main(String[] args) {
        String dateString = "2022-10-29T21:37:22.444+0530";

        // Parse the string into LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

        // Parse the string into OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

        // Print the results
        System.out.println("Parsed LocalDateTime: " + localDateTime);
        System.out.println("Parsed OffsetDateTime: " + offsetDateTime);
    }
}
