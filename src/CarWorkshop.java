import java.util.ArrayList;
import java.util.List;

/**
 * A representation of what attributes and methods a Workshop for cars should have.
 * A car workshop with the type parameter that allows for different type of workshops.
 * @param <T> a type of car.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class CarWorkshop <T extends Car>{
    private double maxCapacity;
    private double nCarsInWorkshop;
    private List<T> carWorkshop;

    public CarWorkshop(List<T> carWorkshop, int maxCapacity, int nCarsInWorkshop) {
        this.carWorkshop = carWorkshop;
        this.maxCapacity = maxCapacity;
        this.nCarsInWorkshop = nCarsInWorkshop;
    }

    /**
     * Retrieves the car that we want from the workshop.
     *
     * @return T the type of car.
     */
    public T retrieveCar() {
        return carWorkshop.remove(0);
    }

    /**
     * Hands the car into a workshop.
     * @param car the car to be added into the workshop.
     */
    void handInCar(T car) {
        carWorkshop.add(car);
    }

    /**
     * Gets the max capacity of the workshop.
     * @return maxCapacity.
     */
    public double getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the max capacity of a workshop.
     * @param maxCapacity the maximum capacity of a workshop.
     */
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
        //saab95Workshop.handInCar(volvo240);
        saab95Workshop.handInCar(saab95);
        //saab95Workshop.retrieveCar(volvo240);
        CarWorkshop<Car> workshop = new CarWorkshop<Car>(5);
        workshop.handInCar(volvo240);

    }
}
