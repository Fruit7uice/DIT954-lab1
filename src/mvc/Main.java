package mvc;

import main.*;
import mvc.controller.CarController;
import mvc.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Positionable> walls = new ArrayList<>();

        walls.add(new Wall(750, 0, 1, 600, 0)); // right wall
        walls.add(new Wall(0, 0, 1, 600, 0)); // Left Wall
        walls.add(new Wall(0, 0, 800, 1, 0)); // Top Wall
        walls.add(new Wall(0, 600, 800, 1, 0)); // Bottom Wall

        List<Vehicle> vehicles = new ArrayList<>();


        vehicles.add(new Saab95());
        vehicles.add(new Volvo240());
        vehicles.add(new Scania());
        // Instance of this class
        CarController cc = new CarController(walls, vehicles);





    }
}
