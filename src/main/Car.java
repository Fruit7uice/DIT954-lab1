package main;

import java.awt.*;

/**
 * A representation of what attributes and methods a car should have.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public abstract class Car extends Vehicle implements ITransportable {

    private int nrDoors; // Number of doors on the car


    /**
     * * The constructor of the car class.T
     *
     * @param currentSpeed initial speed.
     * @param enginePower Power of the engine.
     * @param color Color of the car.
     * @param modelName Name of the car.
     * @param xCord x coordinate of the car.
     * @param yCord y coordinate of the car.
     * @param width of the car.
     * @param height of the car.
     * @param lenght of the car.
     * @param nrDoors number of doors.
     */
    public Car(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord, double width, double height, double lenght, int nrDoors) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght);
        this.nrDoors = nrDoors;
    }

    /**
     * Gets the amount of doors on car.
     * @return the amount of doors.
     */
    public int getNrDoors() {
        return nrDoors;
    }
}
