package guavaTest;

import com.google.common.base.Predicate;

public class FeaturePredicates {


    public static Predicate<Car> carColorPredicate(){
        return new Predicate<Car>() {
            @Override
            public boolean apply(Car input) {
                return  input!=null? input.getColor().equals("red"):false;
            }

        };
    }


    public static Predicate<Car> AllCarsHasColor(){
        return new Predicate<Car>() {
            @Override
            public boolean apply(Car input) {
                return input!=null && input.getColor()!=null && !input.getColor().isEmpty();
            }
        };
    }

}
