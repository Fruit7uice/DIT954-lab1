package main;

public class VehicleBehaviour{

    // TODO BELOW IS MODEL BEHAVIOR, CHANGE FOR FUTURE!

    VehicleBehaviour vb;

    public VehicleBehaviour(VehicleBehaviour vb) {
        this.vb = vb;

    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void raiseTruckbed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).raiseTruckBed();
            }
        }
    }

    void lowerTruckBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).lowerTruckBed();
            }
        }
    }

}
