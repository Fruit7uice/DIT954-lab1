import java.util.ArrayList;
import java.util.List;

public class CarWorkshop <T extends Car>{
    private double maxCapacity;
    private double nCarsInWorkshop;
    private List<T> carWorkshop = new ArrayList<>(5);

    public CarWorkshop(List<T> carWorkshop, int maxCapacity, int nCarsInWorkshop) {
        this.carWorkshop = carWorkshop;
        this.maxCapacity = maxCapacity;
        this.nCarsInWorkshop = nCarsInWorkshop;
    }

    T retrieveCar() {
        return carWorkshop.remove(0);
    }

    void handInCar(T car) {
        carWorkshop.add(car);
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
        CarWorkshop<Saab95> saab95Workshop = new ArrayList<>();
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        saab95Workshop.handInCar(volvo240);
        saab95Workshop.handInCar(saab95);
    }
}
