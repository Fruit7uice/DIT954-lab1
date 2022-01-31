import java.awt.*;

public abstract class Truck extends Vehicle {

    private boolean hasTruckBed;
    private boolean turboOn;

    public Truck(boolean hasTruckBed, double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord);
        this.hasTruckBed = hasTruckBed;
        this.turboOn = false;
    }

    /**
     * Turns on the turbo for the created object
     * by calling for the rule of the variable turboOn to be TRUE.
     */
    private void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turns off the turbo for the created object
     * by calling for the rule of the variable turboOn to be FALSE.
     */
    private void setTurboOff(){
        turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.4;
        return getEnginePower() * 0.01 * turbo;
    }

}
