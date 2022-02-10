package main;

public class Wall {
    public Dir direction;

    public Wall(double x, double y, double width, double height, Dir direction) {
        this.direction = direction;
    }

    public enum Dir {
        HORIZONTAL, VERTICAL;
    }
}
