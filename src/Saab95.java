import java.awt.*;

/**
 * A specification of the car class, describing a Saab95.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Saab95 extends Car{

    /**
     * Variable that holds two possible values, the turbo is either on or not.
     */
    private boolean turboOn;

    /**
     * Constructor for the Saab95 class. The class calls for the superclass, Car, which enables Saab95 to inherit
     * variables declared in Car.
     */
    public Saab95(){
        super(2, 125, 0, Color.red, "Saab95", 0, 0);
        turboOn = false;
        stopEngine();
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

    /**
     * Represents a factor that can be utilized in order to either increase or decrease
     * the speed.
     * @return the factor of what the speed is either going to be increased/decreased with.
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }







}
