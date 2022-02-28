package mvc;

import main.*;
import mvc.controller.CarController;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Collidable> collidables = new ArrayList<>();

        collidables.add(new Barrier(760, 0, 100, 600, 0)); // right wall
        collidables.add(new Barrier(-100, 0, 100, 600, 0)); // Left Wall
        collidables.add(new Barrier(0, -100, 800, 100, 0)); // Top Wall
        collidables.add(new Barrier(0, 560, 800, 100, 0)); // Bottom Wall

        List<Vehicle> vehicles = new ArrayList<>();


        vehicles.add(VehicleFactory.createVolvo240());
        vehicles.add(VehicleFactory.createSaab95());
        vehicles.add(VehicleFactory.createScania());
        // Instance of this class
        CarController cc = new CarController(collidables, vehicles);





    }
}
