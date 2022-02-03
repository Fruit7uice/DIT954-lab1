import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Car> {
    private double maxCapacity;
    private double nCarsInWorkshop = 0;
    private List<T> carWorkshop;


    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.carWorkshop = new ArrayList<>(maxCapacity);
    }


    T retrieveCar(T car) {
        int indexOfCar = carWorkshop.indexOf(car);
        return carWorkshop.remove(indexOfCar);
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
        CarWorkshop<Saab95> saab95Workshop = new CarWorkshop<>(5);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        //saab95Workshop.handInCar(volvo240);
        //saab95Workshop.handInCar(saab95);
        //saab95Workshop.retrieveCar(volvo240);
    }
}
