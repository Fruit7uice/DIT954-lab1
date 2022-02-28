package main;

public abstract class Positionable implements IPositionable { // Change name to Positionable
    private int x;
    private int y;
    private final double width;
    private final double height;
    private final double length;

    public Positionable(int xCord, int yCord, double width, double height, double length) {
        this.x = xCord;
        this.y = yCord;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    /**
     * A getter for the cars current X-Coordinate in a Cartesian coordinate system.
     *
     * @return current X-Coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * A getter for the cars current Y-Coordinate in a Cartesian coordinate system.
     * @return current Y-Coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Getter for the width of the vehicle.
     * @return the width of the vehicle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Getter for the height of the vehicle.
     * @return the height of the vehicle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Getter for the length of the vehicle.
     * @return the length of the vehicle.
     */
    public double getLength(){
        return length;
    }


    /**
     * A setter for the coordinate of the car regarding the x-position.
     */
    public void setX(double xCord) {
        this.x = (int) xCord;
    }

    /**
     * A setter for the coordinate of the car regarding the y-position.
     */
    public void setY(double yCord) {
        this.y = (int) yCord;
    }

    public double getMaxX() {
        return x + width;
    }

    public double getMaxY() {
        return y + height;
    }

}
