package main;

public abstract class Collidable extends Positionable {

    public CollisionDir latestCollision = CollisionDir.NONE;

    public Collidable(int xCord, int yCord, double width, double height, double length) {
        super(xCord, yCord, width, height, length);
    }



    public void vehicleCollision(Vehicle vehicle, Collidable other) {
        //check X movement bounce
        if (getMaxX() + vehicle.getdX() > other.getX() && getX() + vehicle.getdX() < other.getMaxX() &&
                getMaxY() > other.getY() && getY() < other.getMaxY()) {
            vehicle.stopEngine();
            vehicle.setdX(vehicle.getdX()* -1);
            vehicle.startEngine();
            vehicle.move();
        }

        //check Y movement bounce
        if (getMaxX()> other.getX() && getX() < other.getMaxX() &&
                getMaxY() + vehicle.getdY() > other.getY() && getY() + vehicle.getdY() < other.getMaxY()) {
            vehicle.stopEngine();
            vehicle.setdY(vehicle.getdY()*-1);
            vehicle.startEngine();
            vehicle.move();
        }

    }

    public boolean isCollisionWithWalls() {
        boolean toMuchRight = this.getMaxX() > 700;
        boolean toMuchLeft = this.getX() < 0;
        boolean toMuchUp = this.getY() < 0;
        boolean toMuchDown = this.getMaxY() > 600;


        if (toMuchRight) {
            latestCollision = CollisionDir.RIGHT;
        } else if (toMuchLeft) {
            latestCollision = CollisionDir.LEFT;
        } else if (toMuchUp) {
            latestCollision = CollisionDir.ABOVE;
        } else if (toMuchDown) {
            latestCollision = CollisionDir.BELOW;
        } else {
            latestCollision = CollisionDir.NONE;
        }

        return (toMuchUp || toMuchDown || toMuchLeft || toMuchRight);

    }

    private void setLatestCollisionDirection(boolean above, boolean below, boolean leftOf, boolean rightOf) {
        if (!below) {
            latestCollision = CollisionDir.BELOW;
        } else if (!above) {
            latestCollision = CollisionDir.ABOVE;
        } else if (!leftOf) {
            latestCollision = CollisionDir.LEFT;
        } else if (!rightOf) {
            latestCollision = CollisionDir.RIGHT;
        } else {
            latestCollision = CollisionDir.NONE;
        }
    }

    public void collisionBehavior(Vehicle vehicle) {
        if (vehicle.latestCollision.equals(Vehicle.CollisionDir.ABOVE) ||
                vehicle.latestCollision.equals(Vehicle.CollisionDir.BELOW)) {
            vehicle.setdY(-vehicle.getdY());
            vehicle.move();
        }
        if (vehicle.latestCollision.equals(Vehicle.CollisionDir.LEFT) ||
                vehicle.latestCollision.equals(Vehicle.CollisionDir.RIGHT)) {
            vehicle.setdX(-vehicle.getdX());
            vehicle.move();
            System.out.println("Direction inverted");
        }
    }


    public enum CollisionDir {
        ABOVE, BELOW, LEFT, RIGHT, NONE;
    }


}
