import java.util.ArrayList;
import java.util.List;

public class CarWorkshop <T extends Car>{

    private List<T> carWorkshop = new ArrayList<>();

    T retrieveCar() {
        return carWorkshop.remove(0);
    }

    void handInCar(T car) {
        carWorkshop.add(car);
    }

}
