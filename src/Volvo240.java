import java.awt.*;

/**
 * A specification of the car class, describing a Volvo240.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25; // A decimal which determine the speed factor of the car.

    /**
     * Constructor for the Volvo240 class. The class calls for the superclass, Car, which enables Volvo240 to inherit
     * variables declared in Car.
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", 0, 0);
        stopEngine();
    }

    /**
     * Represents a factor which can be used to increase the speed of the car.
     *
     * @return the calculated factor of which the speed increases by.
     */
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }



}
