package jodaAPI;

import org.joda.time.*;

public class JodaAPI {

    /**
     * LocalDate – represents a date without time
     * LocalTime – represents the time without the time zone
     * LocalDateTime – represents both the date and time without a time zone
     * Instant – represents an exact point in time in milliseconds from the Java epoch of 1970-01-01T00:00:00Z
     * Duration – represents the duration in milliseconds between 2 points in time
     * Period – similar to Duration, but allowing access to individual components of the date and time object, like years, month, days, etc.
     * Interval – represents the time interval between 2 instants
     *
     */

    public static LocalDate getCurrentJodaLocalDate(){
        return LocalDate.now();
    }


    public static LocalTime getLocalTime(){
        return LocalTime.now();
    }

    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

    public static DateTime getLocalDatetimeWithTimeZone(){
        return getLocalDateTime().toDateTime();
    }

    public static LocalDate getLocalDateAddingAmericaChicagoTimeZone(){
        return LocalDate.now(DateTimeZone.forID("America/Chicago"));
    }
}
