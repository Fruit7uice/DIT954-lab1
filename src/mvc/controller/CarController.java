package mvc.controller;

import main.*;
import mvc.view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */


public class CarController {


    private final VehicleBehaviour vehicleBehaviour;
    List<Positionable> walls;

    public CarController(List<Positionable> walls) {
        this.walls = walls;
        this.vehicleBehaviour = new VehicleBehaviour(vehicles);

    }

    // member fields:
    List<Vehicle> vehicles = new ArrayList<>();
    CarView frame;


    //methods:

    public static void main(String[] args) {
        List<Positionable> walls = new ArrayList<>();

        walls.add(new Wall(750, 0, 1, 600, 0)); // right wall
        walls.add(new Wall(0, 0, 1, 600, 0)); // Left Wall
        walls.add(new Wall(0, 0, 800, 1, 0)); // Top Wall
        walls.add(new Wall(0, 600, 800, 1, 0)); // Bottom Wall

        // Instance of this class
        CarController cc = new CarController(walls);
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");


        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


    void validateCollision(Vehicle vehicle, List<Positionable> positionables) {

        if (vehicle.isCollisionWithWalls()) {
            System.out.println("Collision detected");
            vehicle.collisionBehavior(vehicle);
            vehicle.stopEngine();

            vehicle.startEngine();
            System.out.println(vehicle.latestCollision);
        }
    }









}
