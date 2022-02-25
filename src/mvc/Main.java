package mvc;

import main.*;
import mvc.controller.CarController;
import mvc.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Collidable> collidables = new ArrayList<>();

        collidables.add(new Wall(750, 0, 0, 600, 0)); // right wall
        collidables.add(new Wall(0, 0, 0, 600, 0)); // Left Wall
        collidables.add(new Wall(0, 0, 800, 0, 0)); // Top Wall
        collidables.add(new Wall(0, 600, 800, 0, 0)); // Bottom Wall

        List<Vehicle> vehicles = new ArrayList<>();


        //vehicles.add(new Saab95());
        //vehicles.add(new Volvo240());
        vehicles.add(new Scania());
        // Instance of this class
        CarController cc = new CarController(collidables, vehicles);





    }
}
