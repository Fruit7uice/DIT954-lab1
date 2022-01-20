import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;


    public Saab95(){
        super(2, 125, Color.red, "Saab95", 0, 0);
        turboOn = false;
        stopEngine();
    }

    private void setTurboOn(){
        turboOn = true;
    }

    private void setTurboOff(){
        turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (!(amount < 0 || amount > 1)) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (!(amount < 0 || amount > 1)) {
            decrementSpeed(amount);
        }
    }



}
