import java.awt.*;

/**
 * A specification of the Car class, describing a Scania.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Scania extends Truck {

    private double truckBedAngle;

    /**
     * The constructor of the car class.
     */
    public Scania() {
        super(0, 770, Color.BLACK, "Scania", 0,0,2.5,4, 20, true, false);
        truckBedAngle = 0;
    }

    public Scania(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double lenght, boolean hasTruckBed, boolean turboOn) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght, hasTruckBed, turboOn);
        this.truckBedAngle = 0;
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

    /**
     * Moves the Scania truck but only if the truck bed is at degree 0.
     */
    @Override
    public void move() {
        if (truckBedAngle == 0) {
           super.move();
        }
    }

    /**
     * Gets the truck's bed angle in degrees.
     * @return truckBedAngle the angle of the truck bed
     */
    public double getTruckBedAngle() {
        return truckBedAngle;
    }

    /**
     * Sets the angle of the truck bed.
     * @param truckBedAngle The angle of the truck bed.
     */
    public void setTruckBedAngle(double truckBedAngle) {
        this.truckBedAngle = truckBedAngle;
    }
}
