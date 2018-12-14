package guavareduce;

import com.google.common.base.Function;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;

public class GuavaReduce {

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
}
