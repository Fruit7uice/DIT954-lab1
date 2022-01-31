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
        truckBedAngle = 0;
    }




}
