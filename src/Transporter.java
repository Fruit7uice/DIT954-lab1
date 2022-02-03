import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class Transporter extends Truck{

    private RampPosition rampPos;
    private boolean loadable;
    private int maxCars;
    private double maxCarWidth = 2.0;
    private double maxCarHeight = 2.0;
    private double maxCarLength = 5.8;
    private double loadingDistance = 1.0;
    private Deque<Car> cargo = new ArrayDeque<>(maxCars);


    /**
     * The position of the ramp can either be up or down.
     */
    private enum RampPosition{
        UP,DOWN;
    }

    public Transporter() {
        super(0, 500, Color.BLACK, "Scania-R-Topline", 0, 0, 2.5, 4, 20, true, false);
        rampPos = RampPosition.UP;
        loadable = true;
        this.maxCars = 10;
    }

    public Transporter(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double lenght, boolean hasTruckBed, boolean turboOn, RampPosition rampPos, boolean loadable, int maxCars) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght, hasTruckBed, turboOn);
        this.rampPos = rampPos;
        this.loadable = loadable;
        this.maxCars = maxCars;
    }

    /**
     * Gets the rammp's position.
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
    private boolean isLoadable(Car car){
        double deltaX = (getxCord() - car.getxCord());
        double deltaY = (getyCord() - car.getyCord());
        boolean closeEnough = (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))) <= loadingDistance;
        if (rampPos == RampPosition.DOWN && closeEnough){
            return true;
        } else return false;
    }

    /**
     * Decides if something is unloadable.
     * @return true if and only if the ramp position is down.
     */
    private boolean isUnloadable(){
        return rampPos == RampPosition.DOWN;
    }


    public void loadTransporter(Car car){
        if (isLoadable(car)){
            cargo.push(car);
            car.setxCord(this.getxCord());
            car.setyCord(this.getyCord());
        }
    }


    public void unloadTransporter(Car car){
        if (isUnloadable()){
            cargo.pop();
        }
        car.setxCord(this.getxCord()+1);
        car.setyCord(this.getyCord()+1);
    }

    @Override
    public void move() {
        if (rampPos == RampPosition.UP){
            super.move();
        }
    }

}
