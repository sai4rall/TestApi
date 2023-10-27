package com.example.getrest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LDTexample {
    public static void main(String[] args){
        System.out.println(LocalDateTime.now());
        String dateTimeString = "2013-10-26T23:31:27.16+0530";

        // Define a custom formatter to parse the input string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSX");

        // Parse the string and convert it to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println(localDateTime);
        Duration duration = Duration.between(localDateTime, LocalDateTime.now());

        System.out.println(duration.toMinutes());

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 10, 26, 12, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2025, 5, 15, 14, 30);

        // Calculate the date-based difference using Period
        Period period = Period.between(dateTime1.toLocalDate(), dateTime2.toLocalDate());

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("Years: " + years);
        System.out.println("Months: " + months);
        System.out.println("Days: " + days);
    }

}
