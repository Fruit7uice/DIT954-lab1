import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Transporter extends Truck{

    private RampPosition rampPos;
    private final double loadDistance = 1.0;
    private boolean isLoadable;


    private enum RampPosition{
        UP,DOWN;
    }
    public Transporter(boolean hasTruckBed, double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord) {
        super(hasTruckBed, currentSpeed, enginePower, color, modelName, xCord, yCord);
        rampPos = RampPosition.UP;
    }


    public RampPosition getRampPos() {
        return rampPos;
    }

    public void setRampPos(RampPosition rampPos) {
        this.rampPos = rampPos;
    }

    @Override
    public void move() {
        if (rampPos == RampPosition.UP){
            super.move();
        }
    }

    private boolean isLoadable(Car car, Transporter transporter){
        double xDistance = (transporter.getxCord() - car.getxCord());
        double yDistance = (transporter.getyCord() - car.getyCord());

        if (rampPos == RampPosition.DOWN && (Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2))) <= loadDistance) {
            return true;
        } else {
            return false;
        }

    }
}
