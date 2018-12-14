package guavareduce;

import com.google.common.base.Function;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.math.BigDecimal;
import java.util.List;

public class GuavaReduceAPI {



    public  <T> T guavaReduce(List<T> numberList , Function<ImmutablePair<T,T>,T> func){
        T acc = numberList.iterator().next();
        return guavaReduce(numberList.subList(1,numberList.size()),acc,func);
    }


    public  <T> T guavaReduce(List<T> numberList , T identity, Function<ImmutablePair<T,T>,T> func){
        T acc = identity;

        for (T inte:numberList) {
            acc = func.apply(new ImmutablePair<>(acc,inte));
        }

        return acc;
    }


    public Integer intSum(List<Integer> numberList){
        return guavaReduce(numberList,sumFunction());
    }

    public Integer intPlus(List<Integer> numberList){
        return guavaReduce(numberList,1,plusFunction());
    }

    public String findLogestWord(List<String> words){
        return guavaReduce(words,findLongestWord());
    }

    public String concatBySeparator(List<String> words , String separator){
        return guavaReduce(words,concatWord(separator));
    }

    public String compareStrings(List<String> words){
        return guavaReduce(words,compareStrings());
    }

    public BigDecimal addBigDecimal(List<BigDecimal> numbers){
        return guavaReduce(numbers,sumBigDecimal());
    }

    public BigDecimal multiplyBigDecimal(List<BigDecimal> numbers){
        return guavaReduce(numbers,multiplyBigDecimal());
    }


    public Function<ImmutablePair<BigDecimal,BigDecimal>,BigDecimal> multiplyBigDecimal(){
        return new Function<ImmutablePair<BigDecimal, BigDecimal>, BigDecimal>() {
            @Override
            public BigDecimal apply(ImmutablePair<BigDecimal, BigDecimal> input) {
                return input.left.multiply(input.right);
            }
        };
    }

    public Function<ImmutablePair<BigDecimal,BigDecimal>,BigDecimal> sumBigDecimal(){
        return new Function<ImmutablePair<BigDecimal, BigDecimal>, BigDecimal>() {
            @Override
            public BigDecimal apply(ImmutablePair<BigDecimal, BigDecimal> input) {
                return input.left.add(input.right);
            }
        };
    }

    public Function<ImmutablePair<String,String>,String>  concatWord(String separator){
        return new Function<ImmutablePair<String, String>, String>() {
            @Override
            public String apply(ImmutablePair<String, String> input) {
                return input.left +separator+ input.right;
            }
        };
    }


    public Function<ImmutablePair<String,String>,String>  findLongestWord(){
        return new Function<ImmutablePair<String, String>, String>() {
            @Override
            public String apply(ImmutablePair<String, String> input) {
                return input.left.length() > input.right.length() ? input.left : input.right;
            }
        };
    }

    private Function<ImmutablePair<Integer,Integer>,Integer> sumFunction(){
        return new Function<ImmutablePair<Integer, Integer>, Integer>() {
            @Override
            public Integer apply(ImmutablePair<Integer, Integer> pair) {
                return pair.left + pair.right;
            }
        };
    }


    private Function<ImmutablePair<Integer,Integer>,Integer> plusFunction(){
        return new Function<ImmutablePair<Integer, Integer>, Integer>() {
            @Override
            public Integer apply(ImmutablePair<Integer, Integer> pair) {
                return pair.left * pair.right;
            }
        };
    }

    public Function<ImmutablePair<String,String>,String> compareStrings(){
        return new Function<ImmutablePair<String, String>, String>() {
            @Override
            public String apply(ImmutablePair<String, String> input) {
                return input.left.compareTo(input.right) <= 0 ? input.left: input.right;
            }
        };
    }
}
