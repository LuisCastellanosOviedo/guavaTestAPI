package guavaReduce;

import com.google.common.base.Function;
import guavareduce.GuavaReduceAPI;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class GuavaReduceTest {

    GuavaReduceAPI guavaReduce = new GuavaReduceAPI();

    @Test
    public void testReduceSum() {
        int sum = guavaReduce.intSum(Arrays.asList(1,2,3,4));
        Assert.assertEquals(10,sum);
    }

    @Test
    public void testReducePlus() {
        int sum =  guavaReduce.intPlus(Arrays.asList(1,2,3,4));
        Assert.assertEquals(24,sum);
    }

    @Test
    public void testLongestString() {
        String logestWord = guavaReduce.findLogestWord(Arrays.asList("GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks"));
        Assert.assertEquals(logestWord,"GeeksforGeeks");
    }

    @Test
    public void testConcat() {
        String concatRes =  guavaReduce.concatBySeparator(Arrays.asList("Geeks", "for", "Geeks"),"-");
        Assert.assertEquals(concatRes,"Geeks-for-Geeks");
    }

    @Test
    public void testComaprator() {
        String concatRes =  guavaReduce.compareStrings(Arrays.asList("apple", "banana", "pie"));
        Assert.assertEquals(concatRes,"apple");
    }

    @Test
    public void testSumBigdecimalOneElement() {
        BigDecimal sum =  guavaReduce.addBigDecimal(Arrays.asList(new BigDecimal(1)));
        Assert.assertEquals(new BigDecimal(1),sum);
    }

    @Test
    public void testSumBigdecimalManyElement() {
        BigDecimal sum =  guavaReduce.addBigDecimal(Arrays.asList(new BigDecimal(1),new BigDecimal(3)));
        Assert.assertEquals(new BigDecimal(4),sum);
    }

    @Test
    public void testMultiplyBigdecimalManyElement() {
        BigDecimal multi =  guavaReduce.multiplyBigDecimal(Arrays.asList(new BigDecimal(1),new BigDecimal(3)));
        Assert.assertEquals(new BigDecimal(3),multi);
    }

    @Test
    public void testReduceSumDouble() {
        //Arrays.asList(1.1, 1.5, 2.5, 5.4).stream().max
        //     double sumDouble =  (Integer) guavaReduce.guavaReduce(Arrays.asList(1.1, 1.5, 2.5, 5.4),0.0,sumFunction());
        //    Assert.assertEquals(10.5,sumDouble,0.0);
    }

















    public Function<ImmutablePair<Integer,Integer>,String> concatLetter(){
        return new Function<ImmutablePair<Integer, Integer>, String>() {
            @Override
            public String apply(ImmutablePair<Integer, Integer> input) {
                return input.left.toString()+input.right.toString();
            }
        };

    }





}
