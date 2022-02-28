package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * A representation of what attributes and methods a vehicle should have.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */

public abstract class Vehicle extends Collidable implements IMoveable {

    public double currentSpeed; // The current speed of the car
    private double enginePower;
    private Color color; // Color of the car
    public String modelName; // The car model name
    private double dX = 1;
    private double dY;
    public Point point = new Point();
    //public String imagePath;
    BufferedImage vehicleImage;
    //File imageFile;



    /**
     * The constructor for the yes.Vehicle class
     *
     * @param currentSpeed initial speed.
     * @param enginePower  power of the engine
     * @param color        color of the vehicle.
     * @param modelName    name of the vehicle.
     * @param xCord        x coordinate of the vehicle.
     * @param yCord        y coordinate of the vehicle.
     * @param width        width of the vehicle.
     * @param height       height of the vehicle.
     * @param length       length of the vehicle.
     */

    public Vehicle(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord,
                   double width, double height, double length, String imagePath) {
        super(xCord, yCord, width, height, length);
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        point.x = xCord;
        point.y = yCord;
        assignImageToVehicle(imagePath);

    }


    public BufferedImage getVehicleImage() {
        ColorModel cm = vehicleImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = vehicleImage.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    private void assignImageToVehicle(String imagePath) {
        try {
            //vehicleImage = ImageIO.read(imageFile);
            vehicleImage = ImageIO.read(Vehicle.class.getResourceAsStream(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the color of a car
     *
     * @return color for a given car
     */
    public Color getColor() {
        return new Color(color.getRGB());
    }



    /**
     * Moves the car in a direction.
     * <p>
     * At any given time the method is going to set the coordinates of the car.
     * It will do this by getting the previous coordinates x and y, of the car, and by then adding
     * the product of the direction * currentSpeed individually to the coordinates of x and y.
     */
    public void move() {
        setXCord(getX() + dX * currentSpeed);
        setYCord(getY() + dY * currentSpeed);
    }


    /**
     * Turns the car right according to a Cartesian coordinate system.
     */
    public void turnRight() {
        if ((dX > 0 || dX < 0) && dY == 0) {
            setdY(dX * -1);
            setdX(0);
        } else if ((dY < 0 || dY > 0) && dX == 0) {
            setdX(dY);
            setdY(0);
        }
    }

    /**
     * Turns the car left according to a cartesian coordinate system.
     */
    public void turnLeft() {
        if ((dX > 0 || dX < 0) && dY == 0) {
            setdY(dX);
            setdX(0);

        } else if ((dY > 0 || dY < 0) && dX == 0) {
            setdX(dY * -1);
            setdY(0);
        }
    }

    /**
     * A getter for the cars current representation of X-Coordinate direction where dX belongs [-1, 1] and dX belongs N
     *
     * @return current representation of X-Coordinate direction
     */
    public double getdX() {
        return dX;
    }

    /**
     * A setter for the direction of the car regarding the dY-direction.
     */

    public void setdX(double dX) {
        this.dX = dX;
    }

    /**
     * A getter for the cars current representation of Y-Coordinate direction where dY belongs [-1, 1] and dY belongs N
     *
     * @return current representation of Y-Coordinate direction
     */
    public double getdY() {
        return dY;
    }

    /**
     * A setter for the direction of the car regarding the dX-direction.
     */

    public void setdY(double dY) {
        this.dY = dY;
    }

    /**
     * Gets the enginePower of a car, it then
     *
     * @return enginePower for a given car.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gets the current speed of the car.
     *
     * @return currentSpeed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Starts the car by setting the @currentSpeed of
     * a car to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Turns of a car engine.
     * Sets current speed of car to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }


    /**
     * Represents the pressing of the gas-pedal.
     * Calls incrementSpeed() when amount is within a certain interval.
     *
     * @param amount is the amount pressed on the gas represented by a decimal number.
     */
    public void gas(double amount) {
        if (!(amount < 0 || amount > 1)) {
            incrementSpeed(amount);
        }
    }

    /**
     * Represents the pressing of the brake-pedal.
     * Calls decrementSpeed() when amount is within a certain interval.
     *
     * @param amount is the amount pressed on the brake represented by a decimal number.
     */
    public void brake(double amount) {
        if (!(amount < 0 || amount > 1)) {
            decrementSpeed(amount);
        }
    }


    /**
     * Sets the speed(increasing) of the car controlled by the amount inputted.
     *
     * @param amount is the restricted amount which can be multiplied to increase speed.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + this.speedFactor() * amount, enginePower);
    }

    /**
     * Sets the speed(decreasing) of the car controlled by the amount inputted.
     *
     * @param amount is the restricted amount which can be multiplied to decrease speed.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - this.speedFactor() * amount, 0);
    }

    /**
     * Represents a factor which can be used to increase the speed of the vehicle.
     *
     * @return the calculated factor of which the speed increases by.
     */
    abstract double speedFactor();




}
