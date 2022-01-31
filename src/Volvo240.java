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
    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Sets the speed(increasing) of the car controlled by the amount inputted.
     * @param amount is the restricted amount which can be multiplied to increase speed.
     */
    private void incrementSpeed(double amount) {
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if (currentSpeed > enginePower) {
            currentSpeed = preCurrentSpeed;
        }
    }

    /**
     * Sets the speed(decreasing) of the car controlled by the amount inputted.
     * @param amount is the restricted amount which can be multiplied to decrease speed.
     */
    private void decrementSpeed(double amount) {
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (currentSpeed < 0) {
            currentSpeed = preCurrentSpeed;
        }
    }

    /**
     * Represents the pressing of the gas-pedal.
     * Calls incrementSpeed() when amount is within a certain interval.
     *
     * @param amount is the amount pressed on the gas represented by a decimal number.
     */
    public void gas(double amount) {
        if (!(amount <= 0 || amount >= 1)) {
            incrementSpeed(amount);
        }
    }

    /**
     * Represents the pressing of the brake-pedal.
     * Calls decrementSpeed() when amount is within a certain interval.
     *
     * @param amount is the amount pressed on the brake represented by a decimal number.
     */
    public void brake(double amount) {
        if (!(amount <= 0 || amount >= 1)) {
            decrementSpeed(amount);
        }
    }


}
