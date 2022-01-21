import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    /**
     * Constructor for the Volvo240 class. The class calls for the superclass, car, which enables Volvo240 to access the
     * data and methods declared in Car.
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", 0, 0);
        stopEngine();
    }

    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount) {
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if (currentSpeed > enginePower) {
            currentSpeed = preCurrentSpeed;
        }
    }

    private void decrementSpeed(double amount) {
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (currentSpeed < 0) {
            currentSpeed = preCurrentSpeed;
        }
    }


    public void gas(double amount) {
        if (!(amount < 0 || amount > 1)) {
            incrementSpeed(amount);
        }
    }


    public void brake(double amount) {
        if (!(amount < 0 || amount > 1)) {
            decrementSpeed(amount);
        }
    }


}
