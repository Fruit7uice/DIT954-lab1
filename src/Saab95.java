import java.awt.*;

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
        super(2, 125, Color.red, "Saab95", 0, 0);
        turboOn = false;
        stopEngine();
    }

    /**
     * The method setTurboOn turns on the turbo for the created object
     * by calling for the rule of the variable turboOn to be TRUE.
     */
    private void setTurboOn(){
        turboOn = true;
    }

    /**
     * The method setTurboOff turns off the turbo for the created object
     * by calling for the rule of the variable turboOn to be FALSE.
     */

    private void setTurboOff(){
        turboOn = false;
    }

    /**
     * speedFactor(); is a representation of a factor that can be utilized in order to either increase or decrease
     * the speed.
     * @return the factor of what the speed is either going to be increased/decreased with.
     */

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * incrementSpeed() sets the currentSpeed to a speed of a higher value in comparison
     * with the speed in the previous state.
     * @param amount is the amount of speed that the current speed is going to be increased by.
     */

    private void incrementSpeed(double amount){
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower){
            currentSpeed = preCurrentSpeed;
        }
    }
    /**
     * decrementSpeed() sets the currentSpeed to a speed of a lower value in comparison
     * with the speed in the previous state.
     * @param amount is the amount of speed that the current speed is going to be decreased by.
     */


    private void decrementSpeed(double amount){
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0){
            currentSpeed = preCurrentSpeed;
        }
    }

    /**
     * The method gas(); is a representation that increases the speed for the car by calling incrementSpeed();.
     * @param amount is the amount of speed that the car is going to be increased by within
     * a certain interval.
     */


    public void gas(double amount){
        if (!(amount < 0 || amount > 1)) {
            incrementSpeed(amount);
        }
    }

    /**
     * The method brake(); is a representation that decreases the speed for the car by calling decrementSpeed();.
     * @param amount is the amount of speed that the car is going to be decreased by within
     * a certain interval.
     */


    public void brake(double amount){
        if (!(amount < 0 || amount > 1)) {
            decrementSpeed(amount);
        }
    }



}
