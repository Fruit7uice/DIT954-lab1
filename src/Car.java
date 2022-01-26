import java.awt.*;

/**
 * A representation of what attributes and methods a car should have.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public abstract class Car implements Moveable {

    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name
    private double xCord;
    private double yCord;
    private double dX;
    private double dY;

    /**
     * The constructor of the car class.
     *
     * @param nrDoors number of doors.
     * @param enginePower Power of the engine.
     * @param color Color of the car.
     * @param modelName Name of the car.
     * @param xCord x coordinate of the car.
     * @param yCord y coordinate of the car.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double xCord, double yCord) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    /**
     * Gets the amount of doors on car.
     * @return the amount of doors.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Gets the enginePower of a car, it then
     * @returns enginePower for a given car.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gets the current speed of the car.
     * @return currentSpeed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Gets the color of a car
     * @returns color for a given car
     */

    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the car to whatever is the input
     * @param clr is the color which is inputted.
     */
    public void setColor(Color clr) {
        color = clr;
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
     * Moves the car in a direction.
     *
     * At any given time the method is going to set the coordinates of the car.
     * It will do this by getting the previous coordinates x && y, of the car, and by then adding
     * the product of the direction * currentSpeed individually to the coordinates of x && y.
     */
    public void move() {
        setxCord(getxCord() + dX * currentSpeed);
        setyCord(getyCord() + dY * currentSpeed);
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
     * A getter for the cars current X-Coordinate in a Cartesian coordinate system.
     * @return current X-Coordinate
     */
    public double getxCord() {
        return xCord;
    }


    /**
     * A setter for the coordinate of the car regarding the x-position.
     */

    public void setxCord(double xCord) {
        this.xCord = xCord;
    }

    /**
     * A getter for the cars current Y-Coordinate in a Cartesian coordinate system.
     * @return current Y-Coordinate
     */
    public double getyCord() {
        return yCord;
    }

    /**
     * A setter for the coordinate of the car regarding the y-position.
     */

    public void setyCord(double yCord) {
        this.yCord = yCord;
    }

    /**
     * A getter for the cars current representation of X-Coordinate direction where dX ∈ [-1, 1] & dX ∈ N
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
     * A getter for the cars current representation of Y-Coordinate direction where dY ∈ [-1, 1] & dY ∈ N
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


}
