package guavaTest;

import javax.validation.constraints.Size;
import java.util.List;


public class CarStore {


    @Size(min = 1)
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
