package regexPoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {


    public static void main(String[] args) {


        testMatch("http://www.google.com");
        testMatch("http://wwwgoogle.com");
        testMatch("http://wwwgooglecom");

        testMatch("https://www.google.com");
        testMatch("https://wwwgoogle.com");
        testMatch("https://wwwgooglecom");

        testMatch("ftp://www.google.com");
        testMatch("ftp://wwwgoogle.com");
        testMatch("ftp://wwwgooglecom");

        testMatch("file://www.google.com");
        testMatch("file://wwwgoogle.com");
        testMatch("file://wwwgooglecom");
        testMatch("file://wwwgooglecom/jghjgj/g");

        testMatch("");
        testMatch("www.google.com");
        testMatch("http:/www.google.com");
        testMatch("http:www.google.com");
        testMatch("httpwww.google.com");
        testMatch("http//www.google.com");
        testMatch("http//------------");
        testMatch("http//8756875686");
        testMatch("http//#$$##$%$$%%$%");


    }

    private static void testMatch(String value) {
        Pattern p = Pattern.compile("^(https?|ftp|file|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;\" +\n" +
                "            \"]*[-a-zA-Z0-9+&@#/%=~_|]");//. represents single character
        Matcher m = p.matcher(value);
        System.out.println("| is valid -->"+m.matches()+" | URL --> "+value);
    }
}
