package edu.wgu.d387_sample_code.translations;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
    public static String convertTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");


        LocalTime localTime = LocalTime.parse(timeString, formatter);
        ZonedDateTime etTime = localTime.atDate(java.time.LocalDate.now()).atZone(ZoneId.of("America/New_York"));


        ZonedDateTime mtTime = etTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utcTime = etTime.withZoneSameInstant(ZoneId.of("UTC"));


        return etTime.format(formatter) + " ET / " +
                mtTime.format(formatter) + " MT / " +
                utcTime.format(formatter) + " UTC";
    }
}