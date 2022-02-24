package main;

import java.awt.*;

/**
 * A specification of the yes.Car class, describing a yes.Scania.
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
        super(0, 770, Color.BLACK, "Scania", 2,200,2.5,4, 20, true, false, "pics/Scania.jpg");
        truckBedAngle = 0;
    }

    public Scania(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord, double width, double height, double lenght, boolean hasTruckBed, boolean turboOn, String imagePath) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght, hasTruckBed, turboOn, imagePath);
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


    /**
     * Moves the yes.Scania truck but only if the truck bed is at degree 0.
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
