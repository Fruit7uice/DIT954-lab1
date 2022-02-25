package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A specification of the car class, describing a yes.Volvo240.
 *
 * @author Johannes Höher
 * @author Jeffrey Wolff
 * @author Joel Leiditz Thorsson
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25; // A decimal which determine the speed factor of the car.
    //public String imagePath = "src/main/pics/Volvo240.jpg"; // Change here to change picture
    /**
     * Constructor for the Volvo240 class. The class calls for the superclass, Car, which enables Volvo240 to inherit
     * variables declared in Car.
     */
    public Volvo240() {
        super(0, 100, Color.black, "Volvo240", 2, 0, 1.8, 1.9, 5.8, 4, "pics/Volvo240.jpg");
        stopEngine();
        //assignImageToVehicle(createImageFile(imagePath));

    }

    public Volvo240(int x, int y) {
        super(0, 100, Color.black, "Volvo240", x, y, 1.8, 1.9, 5.8, 4, "pics/Volvo240.jpg");
    }



    public Volvo240(double currentSpeed, double enginePower, Color color, String modelName, int xCord, int yCord, double width, double height, double lenght, int nrDoors, String imagePath) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, lenght, nrDoors, imagePath);
        stopEngine();
        //assignImageToVehicle(createImageFile(imagePath));
    }

    /**
     * Represents a factor which can be used to increase the speed of the car.
     *
     * @return the calculated factor of which the speed increases by.
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }





}
