package main;

public class VehicleFactory {

    public static Vehicle createVolvo240() {
        return new Volvo240();
    }

    public static Vehicle createSaab95() {
        return new Saab95();
    }

    public static Vehicle createScania() {
        return new Scania();
    }

}
