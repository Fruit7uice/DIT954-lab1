package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * A specification of the car class, describing a yes.Saab95.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Saab95 extends Car{
    //public String imagePath = "pics/Saab95.jpg";


    /**
     * Variable that holds two possible values, the turbo is either on or not.
     */
    private boolean turboOn;

    /**
     * Constructor for the yes.Saab95 class. The class calls for the superclass, yes.Car, which enables yes.Saab95 to inherit
     * variables declared in yes.Car.
     */
    public Saab95(){
        super(0, 125, Color.red, "Saab95", 2, 100, 2, 1.9, 5.9, 4, "pics/Saab95.jpg");
        turboOn = false;
        stopEngine();
    }

    public Saab95(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord,
                  double width, double height, double length, int nrDoors, boolean turboOn, String imagePath) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, length, nrDoors, imagePath);
        this.turboOn = turboOn;
    }

    /**
     * Turns on the turbo for the created object
     * by calling for the rule of the variable turboOn to be TRUE.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turns off the turbo for the created object
     * by calling for the rule of the variable turboOn to be FALSE.
     */
    public void setTurboOff(){
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
