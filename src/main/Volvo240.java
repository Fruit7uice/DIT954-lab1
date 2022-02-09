package main;

import java.awt.*;

/**
 * A specification of the car class, describing a yes.Volvo240.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25; // A decimal which determine the speed factor of the car.

    /**
     * Constructor for the yes.Volvo240 class. The class calls for the superclass, yes.Car, which enables yes.Volvo240 to inherit
     * variables declared in yes.Car.
     */
    public Volvo240() {
        super(0, 100, Color.black, "yes.Volvo240", 0, 0, 1.8, 1.9, 5.8, 4);
        stopEngine();
    }

    public Volvo240(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double lenght, int nrDoors) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght, nrDoors);
        stopEngine();
    }

    /**
     * Represents a factor which can be used to increase the speed of the car.
     *
     * @return the calculated factor of which the speed increases by.
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }



}
