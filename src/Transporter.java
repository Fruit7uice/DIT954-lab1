import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A specification of a transporter which is a type of truck.
 *
 * @author Jeffrey Wolff
 * @author Johannes Höher
 * @author Joel Leiditz Thorsson
 */
public class Transporter extends Truck implements ITransporter<Car> {

    private RampPosition rampPos;
    private boolean loadable;
    private int maxCars;
    private double maxCarWidth = 2.0;
    private double maxCarHeight = 2.0;
    private double maxCarLength = 5.8;
    private double loadingDistance = 1.0;
    private Deque<Car> cargo = new ArrayDeque<>(maxCars);


    /**
     * The default constructor of the transporter class.
     */
    public Transporter() {
        super(0, 500, Color.BLACK, "Scania-R-Topline", 0, 0, 2.5, 4, 20, true, false);
        rampPos = RampPosition.UP;
        loadable = true;
        this.maxCars = 10;
    }

    /**
     * A general constructor of the transporter class.
     *
     * @param currentSpeed
     * @param enginePower the engine's power.
     * @param color of the transporter model.
     * @param modelName name of the transporter model.
     * @param xCord X coordinate of this.
     * @param yCord Y coordinate of this.
     * @param width of this.
     * @param height of this.
     * @param length of this.
     * @param hasTruckBed if the transporter has a truck bed.
     * @param turboOn decides if the turbo is on.
     * @param rampPos decides on the ramp position.
     * @param loadable decides if this is loadable.
     * @param maxCars maximum amount of cargo for the transporter.
     */
    public Transporter(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double length, boolean hasTruckBed, boolean turboOn, RampPosition rampPos, boolean loadable, int maxCars) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, length, hasTruckBed, turboOn);
        this.rampPos = rampPos;
        this.loadable = loadable;
        this.maxCars = maxCars;
    }

    /**
     * Gets the ramps position.
     * @return the position of the ramp.
     */
    public RampPosition getRampPos() {
        return rampPos;
    }

    /**
     * Sets the position of the ramp. The veichle must stand still to be able to set the ramp's position.
     * @param rampPos The position of the ramp.
     */
    public void setRampPos(RampPosition rampPos) {
        if (getCurrentSpeed() == 0){
            this.rampPos = rampPos;
        }
    }


    /**
     * Decides if a car is loadable on the transporter. The distance between the transporter and the car
     * must be maximum 1.0 meters away and the position of the ramp must be down.
     * @param car Only cars are loadable on the car transporter.
     * @return true if and only if the car is loadable.
     */
    @Override
    public boolean isLoadable(Car car) {
        boolean isCorrectSize = (car.getWidth() <= maxCarWidth &&
                car.getHeight() <= maxCarHeight && car.getLength() <= maxCarLength);

        double deltaX = (getXCord() - car.getXCord());
        double deltaY = (getYCord() - car.getYCord());
        boolean closeEnough = (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))) <= loadingDistance;
        if (rampPos == RampPosition.DOWN && closeEnough && isCorrectSize){
            return true;
        } else return false;
    }


    /**
     * Decides if something is unloadable.
     * @return true if and only if the ramp position is down.
     */
    @Override
    public boolean isUnloadable(){
        return (rampPos == RampPosition.DOWN && currentSpeed == 0);
    }


    /**
     * Loads the transporter with a car.
     * @param car the car that gets loaded
     */
    @Override
    public void load(Car car){
        if (isLoadable(car)){
            cargo.push(car);
            car.setXCord(this.getXCord());
            car.setYCord(this.getYCord());
        }
    }

    private void updateCargoCord(){
        for (Car c:cargo) {
            c.setXCord(this.getXCord());
            c.setYCord(this.getYCord());
        }
    }
    
    /**
     * Unloads the transporter with the last car the got loaded is the first to get
     * unloaded.
     */
    public void unload(){
        Car car;
        if (isUnloadable()){
            car = cargo.pop();
            car.setXCord(this.getXCord()+1);
            car.setYCord(this.getYCord()+1);

        }
    }

    /**
     * moves the transporter which only is possible if the ramp is up.
     */
    @Override
    public void move() {
        if (rampPos == RampPosition.UP){
            super.move();
        }
        updateCargoCord();
    }

    /**
     * Getter for the current cargo of the transporter.
     * @return the cargo in form of a Deque.
     */

    public Deque<Car> getCargo() {
        return cargo;
    }
}
