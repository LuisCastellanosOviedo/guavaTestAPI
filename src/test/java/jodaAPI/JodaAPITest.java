package jodaAPI;

import org.junit.Test;

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
}
