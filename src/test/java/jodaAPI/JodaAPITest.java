package jodaAPI;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JodaAPITest {


    @Test
    public void getCurrentLocalDate() {
        System.out.println(JodaAPI.getCurrentJodaLocalDate());
    }


    @Test
    public void getLocalTime() {
        System.out.println(JodaAPI.getLocalTime());
    }

    @Test
    public void getLocalDateTime() {
        System.out.println(JodaAPI.getLocalDateTime());
    }

    @Test
    public void getDateTimeUsingTimeZone() {
        System.out.println("Using timezone --> "+JodaAPI.getLocalDatetimeWithTimeZone());
    }

    @Test
    public void getLocalTimeUsingTimeZone() {
        System.out.println("time with zone -->"+JodaAPI.getLocalDatetimeWithTimeZone().toLocalTime());
    }

    @Test
    public void getDateUsingTimeZone() {
        System.out.println("date with time zone  -->"+ JodaAPI.getLocalDatetimeWithTimeZone().toLocalDate());
    }

    @Test
    public void getLocalDateAmericaChicagoTimeZone() {
        System.out.println(" local Date america chicago --> "+ JodaAPI.getLocalDateAddingAmericaChicagoTimeZone());
    }


    @Test
    public void printDate() {
        System.out.println("now"+LocalDateTime.now());
        System.out.println("tolocalDate"+LocalDateTime.now().toLocalDate());
    }

    @Test
    public void testIsAfterPayDay() {
        System.out.println("testIsAfterPayDay -->"+JodaAPI.isAfterPayDay(org.joda.time.LocalDateTime.now().toDateTime()));
    }

    @Test
    public void testShowDaysToNextYear() {
        System.out.println("testShowDaysToNextYear --> "+JodaAPI.daysToNextYear(org.joda.time.LocalDateTime.now().toDateTime().toLocalDate()).getDays());
    }

    @Test
    public void testIsRentalOverdue() {
        System.out.println("testIsRentalOverdue --> "+JodaAPI.isRentalOverDue(org.joda.time.LocalDateTime.now().toDateTime().minusYears(2)));
    }

    @Test
    public void testPrintDateAsText() {
        System.out.println("testPrintDateAsText --> "+ JodaAPI.getDateAsText(org.joda.time.LocalDateTime.now().toDateTime().toLocalDate()));
    }


    @Test
    public void testLambda() {
        Integer sum = Arrays.asList(1,2,3,4).stream().reduce(0,(x,y)-> x+y);

        List<Integer> numbers =new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(2);


        System.out.println(numbers);


        numbers.add(0,5);

        System.out.println(numbers);

        System.out.println(sum);

    }


    @Test
    public void seniorPerson() {

        LocalDate birthDay = LocalDate.now().minusYears(65);
        LocalDate now = LocalDate.now();
        System.out.println( Years.yearsBetween(birthDay,now).isGreaterThan(Years.years(65)));
    }
}
