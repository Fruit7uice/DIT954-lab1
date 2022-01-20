import java.awt.*;

public abstract class Car implements Moveable {

    private int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name
    private double xCord;
    private double yCord;
    private double dX;
    private double dY;


    public Car(int nrDoors, double enginePower, Color color, String modelName, double xCord, double yCord) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void move() {
        setxCord(getxCord() + dX * currentSpeed);
        setyCord(getyCord() + dY * currentSpeed);
    }


    // Depending on the graphical direction of dY, -dX might be dX
    // Depending on the graphical direction of dY, -dY might be dY

    public void turnRight() {
        if ((dX > 0 || dX < 0) && dY == 0) {
            setdX(0);
            setdY(-dX);
        } else if ((dY < 0 || dY > 0) && dX == 0) {
            setdY(0);
            setdX(-dY);
        }
    }


    // If turning is wrong, changes to setdX() and setdY() :s parameters might have to be negative.
    public void turnLeft() {
        if ((dX > 0 || dX < 0) && dY == 0) {
            setdX(0);
            setdY(dX);
        } else if ((dY > 0 || dY < 0) && dX == 0) {
            setdY(0);
            setdX(dY);

        }
    }


    public double getxCord() {
        return xCord;
    }

    public void setxCord(double xCord) {
        this.xCord = xCord;
    }

    public double getyCord() {
        return yCord;
    }

    public void setyCord(double yCord) {
        this.yCord = yCord;
    }

    public double getdX() {
        return dX;
    }

    public void setdX(double dX) {
        this.dX = dX;
    }

    public double getdY() {
        return dY;
    }

    public void setdY(double dY) {
        this.dY = dY;
    }
}
