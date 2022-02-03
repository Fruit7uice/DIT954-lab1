import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Car> {
    private double maxCapacity;
    private double nCarsInWorkshop = 0;


    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    private List<T> carWorkshop = new ArrayList<>(5);


    T retrieveCar() {
        return carWorkshop.remove(0);
    }

    void handInCar(T car) {
        carWorkshop.add(car);
        nCarsInWorkshop++;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getNCarsInWorkshop() {
        return nCarsInWorkshop;
    }

    public void setNCarsInWorkshop(double nCarsInWorkshop) {
        this.nCarsInWorkshop = nCarsInWorkshop;
    }

    public static void main(String[] args) {
        CarWorkshop<Saab95> saab95Workshop = new CarWorkshop<>(5,0);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        saab95Workshop.handInCar(volvo240);
        saab95Workshop.handInCar(saab95);
        saab95Workshop.retrieveCar(volvo240);
    }
}
