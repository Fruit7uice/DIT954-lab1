package main;

public abstract class Positionables { // Change name to Positionable
    private int x;
    private int y;
    private final double width;
    private final double height;

    public Positionables(int xCord, int yCord, double width, double height) {
        this.x = xCord;
        this.y = yCord;
        this.width = width;
        this.height = height;
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
     * A setter for the coordinate of the car regarding the x-position.
     */
    public void setXCord(double xCord) {
        this.x = (int) xCord;
    }
    
    /**
     * A setter for the coordinate of the car regarding the y-position.
     */
    public void setYCord(double yCord) {
        this.y = (int) yCord;
    }

    public double getMaxX() {
        return x + width;
    }

    public double getMaxY() {
        return y + height;
    }

}
