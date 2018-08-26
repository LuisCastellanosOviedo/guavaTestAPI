package guavaOptional;

import com.google.common.base.Optional;
import guavaTest.Car;

import java.util.HashMap;
import java.util.Map;

public class GuavaOptionalAPI {
    private static Map<String,Car> carList= new HashMap<>();

    static {
        Car kia = Car.builder().brand("kia").build();
        carList.put("kia",kia);
    }

    public Optional returnAbsentOptional(){
        return Optional.absent();
    }

    public Optional<Car> existCarByBrand(String brand) {
       return carList.get(brand)!=null?Optional.of(carList.get(brand)):Optional.absent();
    }


    public Optional<String> mayReturnNull(String val){
        return Optional.fromNullable(val);
    }
}
