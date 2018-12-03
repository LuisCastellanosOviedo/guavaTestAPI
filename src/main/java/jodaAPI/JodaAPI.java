package jodaAPI;

import org.joda.time.*;

import java.util.Locale;

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


    public static boolean isAfterPayDay(DateTime dateTime){
        if(dateTime.getMonthOfYear() == 2){
            return dateTime.getDayOfMonth() > 26;
        }

        return dateTime.getDayOfMonth() > 28 ;
    }

    public static Days daysToNextYear(LocalDate today){
        LocalDate nextYear = today.plusYears(1).withDayOfYear(1);
        return Days.daysBetween(today,nextYear);
    }

    public static Boolean isRentalOverDue(DateTime dateTimeRented){
        Period rentalPeriod = new Period().withDays(2).withHours(12);
        return dateTimeRented.plus(rentalPeriod).isBeforeNow();
    }

    public static String getDateAsText(LocalDate dateToFormat){
        return dateToFormat.monthOfYear().getAsText(Locale.ENGLISH);

    }
}
