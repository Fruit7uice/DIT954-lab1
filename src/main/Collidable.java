package main;

public abstract class Collidable extends Positionables{




    public CollisionDir latestCollision = CollisionDir.NONE;

    public Collidable(double xCord, double yCord, double width, double height) {
        super(xCord, yCord, width, height);
    }

    public boolean isCollisionWithOther(Positionables other) {
        boolean above = other.getMaxY() < this.getYCord();
        boolean below = other.getYCord() > this.getMaxY();
        boolean leftOf = other.getMaxX() < this.getXCord();
        boolean rightOf = other.getXCord() > this.getMaxX();
        setLatestCollisionDirection(above, below, leftOf, rightOf);
        return !(above || below || leftOf || rightOf);

    }

    public boolean isCollisionWithWalls() {
        boolean toMuchRight = this.getMaxX() > 700;
        boolean toMuchLeft = this.getXCord() < 0;
        boolean toMuchUp = this.getYCord() < 0;
        boolean toMuchDown = this.getMaxY() > 600;


        if (toMuchRight){
            latestCollision = CollisionDir.RIGHT;
        } else if (toMuchLeft){
            latestCollision = CollisionDir.LEFT;
        } else if (toMuchUp){
            latestCollision = CollisionDir.ABOVE;
        } else if (toMuchDown){
            latestCollision = CollisionDir.BELOW;
        }else{
            latestCollision = CollisionDir.NONE;
        }

        return (toMuchUp || toMuchDown || toMuchLeft || toMuchRight);

    }

    private void setLatestCollisionDirection(boolean above, boolean below, boolean leftOf, boolean rightOf) {
        if (!below){
            latestCollision = CollisionDir.BELOW;
        } else if (!above){
            latestCollision = CollisionDir.ABOVE;
        }else if (!leftOf){
            latestCollision = CollisionDir.LEFT;
        } else if (!rightOf){
            latestCollision = CollisionDir.RIGHT;
        } else{
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


    public enum CollisionDir{
        ABOVE,BELOW,LEFT,RIGHT, NONE;
    }













}
