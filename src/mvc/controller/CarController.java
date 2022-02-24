package mvc.controller;

import main.*;
import mvc.view.CarView;

import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */


public class CarController {

    // Model variables
    VehicleBehaviour vehicleBehaviour;
    List<Positionable> walls;
    UpdateAnimation animation;

    // member fields:
    public List<Vehicle> vehicles;
    public CarView frame;


    public CarController(List<Positionable> walls, List<Vehicle> vehicles) {
        this.walls = walls;
        this.vehicles = vehicles;


        // Model package
        vehicleBehaviour = new VehicleBehaviour(vehicles);
        animation = new UpdateAnimation(vehicles);
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", animation);

        EventHandler eventHandler = new EventHandler(this, frame);
        eventHandler.addActionsToButtons();
    }



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
