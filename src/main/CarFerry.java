package main;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A representation of what attributes and method a car ferry should have.
 * A car ferry type para meter allows for different type of cars to get loaded.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class CarFerry extends Vehicle implements ITransporter<Car> {


    private RampPosition rampPos;
    private double maxCapacity;
    private Deque<Car> ferryCargo;
    private double loadingDistance = 1;

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
    public CarFerry(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord, double width, double height, double length, int maxCapacity) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, length);
        this.ferryCargo = new ArrayDeque<>(maxCapacity) {
        };
        rampPos = RampPosition.UP;
    }

    /**
     * A default constructor for the yes.CarFerry class.
     */
    public CarFerry(){
        super(0, 1980, Color.WHITE, "FerryDelux", 0,0, 15, 4, 91);
        maxCapacity = 75;
        this.ferryCargo = new ArrayDeque<>(75);
        rampPos = RampPosition.UP;

    }

    /**
     * Moves the ferry.
     * @return the speed factor.
     */
    @Override
    protected double speedFactor() {
        return 5;
    }

    /**
     * Getter for the position of the ramp.
     * @return the position of the ramp, ramp is either up or down.
     */


    public RampPosition getRampPos() {
        return rampPos;
    }

    /**
     * Setter for the position of the ramp.
     * @param rampPos is the position of the ramp.
     */


    public void setRampPos(RampPosition rampPos) {
        this.rampPos = rampPos;
    }

    /**
     * Checks if a car is loadable or not
     * @param car The car that is supposed to be loaded onto a transporter.
     * @return True if the car is able to be transported.
     */

    @Override
    public boolean isLoadable(Car car) {
        boolean isFull = maxCapacity <= ferryCargo.size();
        double deltaX = (getX() - car.getX());
        double deltaY = (getY() - car.getY());
        boolean closeEnough = (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))) <= loadingDistance;
        if (rampPos == RampPosition.DOWN && closeEnough && !isFull && currentSpeed == 0){
            return true;
        } else return false;
    }

    /**
     * Checks if a car is unLoadable or not
     * @return True if the car is able to be unloaded.
     */

    @Override
    public boolean isUnloadable() {
        return (rampPos == RampPosition.DOWN && currentSpeed == 0);
    }

    /**
     * Loads the cargo of this.
     * @param car Cars are the only cargo of a car ferry.
     */
    @Override
    public void load(Car car) {
        if (isLoadable(car)){
            ferryCargo.addLast(car);
            car.setXCord(this.getX());
            car.setYCord(this.getY());
        }
    }

    /**
     * Unloads the cargo of this.
     */
    @Override
    public void unload() {
        Car car;
        if (isUnloadable()){
            car = ferryCargo.pop();
            car.setXCord(this.getX()+1);
            car.setYCord(this.getY()+1);
        }

    }

    /**
     * Gets the cargo of the ferry. A car ferry can only take cars as cargo.
     * @return ferryCargo the cargo.
     */
    @Override
    public Deque<Car> getCargo() {
        return ferryCargo;
    }



}
