package codingdojo;

import com.google.common.base.Function;

import java.util.List;

public class FizzBuzzGame {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";




    public String of(int i,List<Function<Integer,String>> filters) {
        if(i == 0){
            return  "0";
        }
        String value = applyFilters(i,filters);

        return !value.isEmpty()?value:String.valueOf(i);
    }

    private String applyFilters(int i,List<Function<Integer,String>> filters) {
    /* if (i % 3 == 0 && i % 5 == 0){
         return  FIZZ+BUZZ;
     }*/


        String value ="";

        for (Function filter:filters) {
            value += filter.apply(i);
        }

        /*
        if(i % 3 == 0){
            value += FIZZ;
        }

        if (i % 5 == 0 ){
            value += BUZZ;
        }
        */


        return value;
    }


}
