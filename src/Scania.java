import java.awt.*;

/**
 * A specification of the Car class, describing a Scania.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Scania extends Car {

    private double truckBedAngle;
    private boolean turboOn;

    /**
     * The constructor of the car class.
     */
    public Scania() {
        super(2, 770, Color.WHITE, "Scania", 0, 0);
        truckBedAngle = 70;
        turboOn = false;
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
     * Raises the truck bed with an angle of 10 degrees at a time. The truck bed
     * cannot be raised more than 70 degrees and the car has to stand still.
     */
    public void raiseTruckBed(){
        if (!(truckBedAngle >= 70) && getCurrentSpeed() == 0){
            truckBedAngle += 10;
            System.out.println(truckBedAngle);
        } else{
            System.out.println("Not possible");
        }
    }

    /**
     * Lowers the truck bed with an angle of 10 degrees at a time.
     * The truck bed cannot be lowered more than 0 degrees.
     */
    public void lowerTruckBed(){
        if (!(truckBedAngle <= 0) && getCurrentSpeed() == 0){
            truckBedAngle -= 10;
            System.out.println(truckBedAngle);
        } else{
            System.out.println("Not possible");
        }
    }

    public static void main(String[] args) { // Testing methods
        Scania scania = new Scania();
        scania.lowerTruckBed();
        scania.raiseTruckBed();

    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.4;
        return enginePower * 0.01 * turbo;
    }


    @Override
    public void move() {
        if (truckBedAngle == 0) {
            setxCord(getxCord() + getdX() * currentSpeed);
            setyCord(getyCord() + getdY() * currentSpeed);
        }
    }

}
