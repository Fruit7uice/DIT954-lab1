package main;

public abstract class Positionables { // Change name to Positionable
    private double xCord;
    private double yCord;
    private double width;
    private double height;

    public Positionables(double xCord, double yCord, double width, double height) {
        this.xCord = xCord;
        this.yCord = yCord;
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
    public double getXCord() {
        return xCord;
    }


    /**
     * A setter for the coordinate of the car regarding the x-position.
     */

    public void setXCord(double xCord) {
        this.xCord = xCord;
    }

    /**
     * A getter for the cars current Y-Coordinate in a Cartesian coordinate system.
     * @return current Y-Coordinate
     */
    public double getYCord() {
        return yCord;
    }

    /**
     * A setter for the coordinate of the car regarding the y-position.
     */

    public void setYCord(double yCord) {
        this.yCord = yCord;
    }

    public double getMaxX() {
        return xCord + width;
    }

    public double getMaxY() {
        return yCord + height;
    }

}
