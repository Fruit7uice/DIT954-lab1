package main;

public abstract class Collidable extends Positionable {

    public CollisionDir latestCollision = CollisionDir.NONE;
    private boolean isCollision = false;

    public Collidable(int xCord, int yCord, double width, double height, double length) {
        super(xCord, yCord, width, height, length);
    }

    public boolean intersects(Collidable other) {
        boolean above = other.getMaxY() < getY();
        boolean below = other.getY() > getMaxY();
        boolean leftOf = other.getMaxX() < getX();
        boolean rightOf = other.getX() > getMaxX();
        setLatestCollisionDirection(above, below, leftOf, rightOf);
        return !(above || below || leftOf || rightOf);
    }

    public boolean isCollision(Collidable other) {
        boolean above = other.getMaxY() < this.getY();
        boolean below = other.getY() > this.getMaxY();
        boolean leftOf = other.getMaxX() < this.getX();
        boolean rightOf = other.getX() > this.getMaxX();
        if (!(above || below || leftOf || rightOf)){
            isCollision = true;
            setLatestCollisionDirection(above, below, leftOf, rightOf);
        }
        else {
            isCollision = false;
        }
        return isCollision;
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

    /*
    public boolean isCollisionWithWalls() {
        boolean toMuchRight = this.getMaxX() < 700;
        boolean toMuchLeft = this.getX() > 0;
        boolean toMuchUp = this.getY() > 0;
        boolean toMuchDown = this.getMaxY() < 600;


        if (!toMuchRight) {
            latestCollision = CollisionDir.RIGHT;
        } else if (!toMuchLeft) {
            latestCollision = CollisionDir.LEFT;
        } else if (!toMuchUp) {
            latestCollision = CollisionDir.ABOVE;
        } else if (!toMuchDown) {
            latestCollision = CollisionDir.BELOW;
        } else {
            latestCollision = CollisionDir.NONE;
        }

        return (toMuchUp || toMuchDown || toMuchLeft || toMuchRight);

    }

     */

    private void setLatestCollisionDirection(boolean above, boolean below, boolean leftOf, boolean rightOf) {
        if ((above || below)) {
            latestCollision = CollisionDir.HORISONTAL;
        } else if ((leftOf || rightOf)) {
            latestCollision = CollisionDir.VERTICAL;
        } else {
            latestCollision = CollisionDir.NONE;
        }
    }

    public void collisionBehavior(Vehicle vehicle) {
        if (vehicle.latestCollision.equals(CollisionDir.HORISONTAL)) {
            vehicle.setdY(-vehicle.getdY());
            System.out.println("Y-Direction inverted");
        }
        if (vehicle.latestCollision.equals(CollisionDir.VERTICAL)) {
            vehicle.setdX(-vehicle.getdX());
            vehicle.move();
            System.out.println("X-Direction inverted");
        }
    }


    public enum CollisionDir {
        VERTICAL, HORISONTAL, NONE;
    }


}
