import java.awt.*;

public class Transporter extends Truck{

    private RampPosition rampPos;
    private boolean loadable;
    //private double


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
}
