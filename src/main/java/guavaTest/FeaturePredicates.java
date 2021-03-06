package guavaTest;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class FeaturePredicates {


    public static Predicate<Car> carColorPredicate(){
        return new Predicate<Car>() {
            @Override
            public boolean apply(Car input) {
                return  input!=null? input.getColor().equals("red"):false;
            }

        };
    }


    public static Predicate<Car> allCarsHasColor(){
        return new Predicate<Car>() {
            @Override
            public boolean apply(Car input) {
                return input!=null && input.getColor()!=null && !input.getColor().isEmpty();
            }
        };
    }


    public static Predicate mixPredicate(){
        return Predicates.and(carColorPredicate(),allCarsHasColor());
    }

}
