package main;

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
    private List<T> carWorkshop;

    /**
     *The constructor of a car workshop.
     * @param maxCapacity maximum capacity of this.
     */
    public CarWorkshop(int maxCapacity) {
        this.carWorkshop = new ArrayList<>(maxCapacity);
        this.maxCapacity = maxCapacity;
    }


    /**
     * Retrieves the car that we want from the workshop.
     *
     * @return T the type of car.
     */
    public T retrieveCar(T car) {
        int indexOf = carWorkshop.indexOf(car);
        return carWorkshop.remove(indexOf);
    }

    /**
     * Hands the car into a workshop.
     * @param car the car to be added into the workshop.
     */
    public void handInCar(T car) {
        if (carWorkshop.size() >= maxCapacity){
            System.out.println("The workshop is full");
        }else {
            carWorkshop.add(car);
        }
    }

    /**
     * Gets the max capacity of the workshop.
     * @return maxCapacity.
     */
    public double getMaxCapacity() {
        return maxCapacity;
    }


    /**
     * Getter for the amount of cars in the workshop.
     * @return the amount of car
     */
    public double getNCarsInWorkshop() {
        return carWorkshop.size();
    }

/*
    public static void main(String[] args) {
        CarWorkshop<Saab95> saab95Workshop = new CarWorkshop<>(5);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        saab95Workshop.handInCar(saab95);
        saab95Workshop.retrieveCar(saab95);
        //saab95Workshop.handInCar(volvo240);
        CarWorkshop<Car> workshop = new CarWorkshop<>(5);
        workshop.handInCar(volvo240);
    }

 */
}
