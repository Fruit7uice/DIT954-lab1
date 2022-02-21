package main;

import java.awt.*;

/**
 * A representation of what attributes and methods a truck should have.
 *
 * @author Jeffrey Wolff
 * @author Johannes Höher
 * @author Joel Leiditz Thorsson
 */
public abstract class Truck extends Vehicle {

    private boolean hasTruckBed;
    private boolean turboOn;

    /**
     * Constructor for the yes.Truck-class.
     */

    public Truck(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord, double width, double height, double lenght, boolean hasTruckBed, boolean turboOn) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght);
        this.hasTruckBed = hasTruckBed;
        this.turboOn = turboOn;
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
     * Represents the factor which the speed increases and depends on the power of the engine
     * and the tubo.
     * @return the speedFactor.
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.4;
        return getEnginePower() * 0.01 * turbo;
    }

}
