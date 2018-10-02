package regexPoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDecimal {


    public static void main(String[] args) {


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
    }
}
