package guavaTest;

import com.google.common.base.Function;

public class FeatureFunctionGuava {


    public static Function<Car, Camioneta> convertTOCamioneta() {
        return new Function<Car, Camioneta>() {
            @Override
            public Camioneta apply(Car input) {
                Camioneta camioneta = new Camioneta();
                camioneta.setColor(input.getColor());
                return camioneta;
            }
        };
    }


    public static Function<Camioneta, Boolean> hasRedColor() {
        return new Function<Camioneta, Boolean>() {
            @Override
            public Boolean apply(Camioneta input) {
                return input.getColor().equals("red");
            }
        };
    }

    public static Function<Camioneta, Car> convertTOCar() {
        return new Function <Camioneta,Car>() {
            @Override
            public Car apply(Camioneta input) {
                Car car = new Car();
                car.setColor(input.getColor());
                return car;
            }
        };
    }



}
