import java.awt.*;

/**
 * A representation of what attributes and methods a car should have.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public abstract class Car extends Vehicle {

    private int nrDoors; // Number of doors on the car


    /**
     * The constructor of the car class.
     *
     * @param nrDoors number of doors.
     * @param enginePower Power of the engine.
     * @param currentSpeed initial speed.
     * @param color Color of the car.
     * @param modelName Name of the car.
     * @param xCord x coordinate of the car.
     * @param yCord y coordinate of the car.
     */
    public Car(int nrDoors,double enginePower, double currentSpeed, Color color, String modelName, double xCord, double yCord){
        super(currentSpeed, enginePower, color, modelName, xCord, yCord);
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
