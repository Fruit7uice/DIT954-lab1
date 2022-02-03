import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarFerry<T extends Car> extends Vehicle {


    private double maxCapacity;
    private double nCarsInWorkshop = 0;
    private List<T> ferryCargo;


    public CarFerry(double currentSpeed, double enginePower, Color color, String modelName, double xCord, double yCord, double width, double height, double length, int maxCapacity) {
        super(currentSpeed, enginePower, color, modelName, xCord, yCord, width, height, length);
        this.ferryCargo = new ArrayList<T>(maxCapacity);
    }

    public CarFerry(){
        super(0, 1980, Color.WHITE, "FerryDelux", 0,0, 15, 4, 91);
        maxCapacity = 75;
        this.ferryCargo = new ArrayList<T>(75);
    }


    @Override
    protected double speedFactor() {
        return 5;
    }
}
