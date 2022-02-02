import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Transporter extends Truck{

    private RampPosition rampPos;
    private boolean loadable;
    private int maxCars;
    private double maxCarWidth = 2.0;
    private double maxCaHeight = 2.0;
    private double maxCarlenght = 5.8;
    private double loadingDistance = 1.0;
    private Deque<Car> cargo = new ArrayDeque<>(maxCars);




    private enum RampPosition{
        UP,DOWN;
    }

    public Transporter() {
        super(true, 0, 500, Color.BLACK, "Scania-R-Topline", 0, 0);
        rampPos = RampPosition.UP;
        loadable = true;
        this.maxCars = 10;
    }

    public Transporter(int maxCars, boolean hasTruckBed, double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord) {
        super(hasTruckBed, currentSpeed, enginePower, color, modelName, xCord, yCord);
        rampPos = RampPosition.UP;
        loadable = true;
        this.maxCars = maxCars;
    }


    public RampPosition getRampPos() {
        return rampPos;
    }

    public void setRampPos(RampPosition rampPos) {
        if (getCurrentSpeed() == 0){
            this.rampPos = rampPos;
        }
    }

    private boolean isLoadable(Car car){
        double deltaX = (getxCord() - car.getxCord());
        double deltaY = (getyCord() - car.getyCord());
        boolean closeEnough = (Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))) <= loadingDistance;
        if (rampPos == RampPosition.DOWN && closeEnough){
            return true;
        } else return false;
    }

    public void loadTransporter(Car car){
        if (isLoadable(car)){
            cargo.push(car);
        }
    }

    @Override
    public void move() {
        if (rampPos == RampPosition.UP){
            super.move();
        }
    }
}
