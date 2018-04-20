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
}
