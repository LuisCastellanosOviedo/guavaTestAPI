package regexPoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDecimal {


  /*  public static void main(String[] args) {


        testMatch("5");
        testMatch("3.4");
        testMatch("375757.43");
        testMatch("375757.433");
        testMatch("a");
        testMatch("22342.3");

    }

    private static void testMatch(String value) {
        Pattern p = Pattern.compile("^\\d+\\.*\\d*$");//. represents single character
        Matcher m = p.matcher(value);
        System.out.println("value --> "+value+" is valid -->"+m.matches());
    }*/
    public static void main(String[] args) {


        testMatch("1.234.56");


    }

    private static void testMatch(String value) {
        Pattern p = Pattern.compile("^(?:(?:0|[1-9][0-9]{0,2})(?:,[0-9]{3})*(?:\\.(?:[0-9]{3},)*[0-9]{2})?)$");//. represents single character
        Matcher m = p.matcher(value);
        System.out.println("value --> "+value+" is valid -->"+m.matches());
    }

  /*  public static void main(String[] args) {


        testMatch("6576576567");


    }

    private static void testMatch(String value) {
        Pattern p = Pattern.compile("^(?=.{0,100}$)(([^<>()[\\\\]\\.,;:\\s@\"]+(\\.[^<>()[\\\\]\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");//. represents single character
        Matcher m = p.matcher(value);
        System.out.println("value --> "+value+" is valid -->"+m.matches());
    }*/
}
