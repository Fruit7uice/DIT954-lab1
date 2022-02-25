package main;

import java.util.List;
import java.util.Random;

public class VehicleBehaviour{

    // TODO BELOW IS MODEL BEHAVIOR, CHANGE FOR FUTURE!

    List<Vehicle> vehicles;

    Random random = new Random();


    public VehicleBehaviour(List<Vehicle> vehicles) {
        this.vehicles = vehicles;

    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
        System.out.println("Gas amount");
    }

    public void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
        System.out.println("brake");
    }

    public void startEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    public void stopEngine() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void raiseTruckbed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).raiseTruckBed();
            }
        }
    }

    public void lowerTruckBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals((Scania.class))) {
                ((Scania) vehicle).lowerTruckBed();
            }
        }
    }

    public void addCar(){
        if(vehicles.size() < 10){
            Vehicle newVehicle =  VehicleFactory.createScania();
            newVehicle.setXCord(random.nextInt(100,700));
            newVehicle.setYCord(random.nextInt(100,500));
            newVehicle.setdX(random.nextInt(-1,1));
            newVehicle.setdY(random.nextInt(-1,1));
            directionBehaviour(newVehicle);
            vehicles.add(newVehicle);
        }
    }

    public void directionBehaviour(Vehicle newVehicle){
        while(newVehicle.getdX() == 0 && newVehicle.getdY() == 0) {
            newVehicle.setdX(random.nextInt(-1, 1));
            newVehicle.setdY(random.nextInt(-1, 1));
        }

    }




    public void removeCar(){
        if(vehicles.size() > 0){
            Vehicle first = vehicles.get(0);
            vehicles.remove(first);
        }
    }

}
