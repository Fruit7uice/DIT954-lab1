import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A representation of what attributes and method a car ferry should have.
 * A car ferry type para meter allows for different type of cars to get loaded.
 * @param <T> a type of car.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class CarFerry<T extends Car> extends Vehicle {


    private double maxCapacity;
    private List<T> ferryCargo;

    /**
     * A general constructor for the carFerry class.
     *
     * @param currentSpeed speed of this.
     * @param enginePower engine power of this.
     * @param color of the car ferry.
     * @param modelName model of this.
     * @param xCord x coordinate of this.
     * @param yCord y coordinate of this.
     * @param width of this.
     * @param height of this.
     * @param length of this.
     * @param maxCapacity maximum capacity of this.
     */
    public CarFerry(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double length, int maxCapacity) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, length);
        this.ferryCargo = new ArrayList<T>(maxCapacity);
    }

    /**
     * A default constructor for the CarFerry class.
     */
    public CarFerry(){
        super(0, 1980, Color.WHITE, "FerryDelux", 0,0, 15, 4, 91);
        maxCapacity = 75;
        this.ferryCargo = new ArrayList<T>(75);
    }

    /**
     * Moves the ferry.
     * @return the speed factor.
     */
    @Override
    protected double speedFactor() {
        return 5;
    }

}
