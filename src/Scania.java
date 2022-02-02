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
        super(true,2, 770, Color.WHITE, "Scania", 0, 0);
        truckBedAngle = 0;
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
    public void move() {
        if (truckBedAngle == 0) {
           super.move();
        }
    }

    public double getTruckBedAngle() {
        return truckBedAngle;
    }

    public void setTruckBedAngle(double truckBedAngle) {
        this.truckBedAngle = truckBedAngle;
    }
}
