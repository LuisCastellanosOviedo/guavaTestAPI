package codingdojo;

import com.google.common.base.Function;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static codingdojo.FizzBuzzGame.BUZZ;
import static codingdojo.FizzBuzzGame.FIZZ;

public class FizzBuzzGameTest {



    private FizzBuzzGame fizzBuzzGame;
    private List<Function<Integer,String>> filters;


    @Before
    public void setUp() throws Exception {
        fizzBuzzGame = new FizzBuzzGame();
        Function<Integer,String> fizz = new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return input % 3 == 0 ?FIZZ: "";
            }
        };

        Function<Integer,String> buzz = new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return input % 5 == 0 ?BUZZ: "";
            }
        };

        filters =    Arrays.asList(fizz,buzz);

    }

    @Test
    public void fizzBuzz0_0() {
        Assert.assertEquals(fizzBuzzGame.of(0,filters),"0");
    }

    @Test
    public void fizzBuzz1_1() {
        Assert.assertEquals(fizzBuzzGame.of(1,filters),"1");
    }

    @Test
    public void fizzBuzz3_Fizz() {
        Assert.assertEquals(fizzBuzzGame.of(3,filters), FIZZ);
    }

    @Test
    public void fizzBuzz_4_4() {
        Assert.assertEquals(fizzBuzzGame.of(4,filters),"4");
    }

    @Test
    public void fizzBuzz5_Buzz() {
        Assert.assertEquals(fizzBuzzGame.of(5,filters),BUZZ);
    }

    @Test
    public void fizzBuzz9_fizz() {
        Assert.assertEquals(fizzBuzzGame.of(9,filters),FIZZ);
    }

    @Test
    public void fizzBuzz10_Buzz() {
        Assert.assertEquals(fizzBuzzGame.of(10,filters),BUZZ);
    }

    @Test
    public void fizzBuzz15_fizzBuzz() {
        Assert.assertEquals(fizzBuzzGame.of(15,filters),FIZZ+BUZZ);
    }
}
