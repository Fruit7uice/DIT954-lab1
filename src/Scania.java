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

    /**
     * The constructor of the car class.
     */
    public Scania() {
        super(2, 770, Color.WHITE, "Scania", 0, 0);
        truckBedAngle = 70;
    }


    public void raiseTruckBed(){
        if (!(truckBedAngle >= 70) && getCurrentSpeed() == 0){
            truckBedAngle += 10;
            System.out.println(truckBedAngle);
        } else{
            System.out.println("Not possible");
        }
    }
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

}
