package mvc.controller;

import main.*;
import mvc.view.CarView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */


public class CarController {

    // Model variables
    VehicleBehaviour vehicleBehaviour;
    private UpdateAnimation animation;

    protected CarView frame;


    public CarController(List<Collidable> collidables, List<Vehicle> vehicles) {
        // Model package
        animation = new UpdateAnimation(vehicles, collidables);

        vehicleBehaviour = new VehicleBehaviour(vehicles);
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", animation, animation.getVehicles());

        EventHandler eventHandler = new EventHandler(this, frame);
    }










}
