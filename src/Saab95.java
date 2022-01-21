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

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower){
            currentSpeed = preCurrentSpeed;
        }
    }

    
    private void decrementSpeed(double amount){
        double preCurrentSpeed = getCurrentSpeed();
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0){
            currentSpeed = preCurrentSpeed;
        }
    }

    public void gas(double amount){
        if (!(amount < 0 || amount > 1)) {
            incrementSpeed(amount);
        }
    }


    public void brake(double amount){
        if (!(amount < 0 || amount > 1)) {
            decrementSpeed(amount);
        }
    }



}
