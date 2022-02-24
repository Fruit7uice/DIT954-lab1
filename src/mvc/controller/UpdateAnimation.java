package mvc.controller;

import main.Positionable;
import main.Saab95;
import main.Vehicle;
import main.Volvo240;
import mvc.Observer;
import mvc.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpdateAnimation implements ActionListener {

    List<Observer> observers = new ArrayList<>();

    // The frame that represents this instance View of the MVC pattern
    //CarView frame;

    //DrawPanel drawPanel;

    //EventHandler eventHandler = new EventHandler();

    private List<Vehicle> vehicles;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, this);

    public UpdateAnimation(List<Vehicle> vs) {
        vehicles = vs;
        timer.start();
    }


    public void update(){
        for (Vehicle vehicle : vehicles) {
            validateCollision(vehicle, CarController.walls);
            //System.out.println("Collision checking?");
            vehicle.move();

            int x = Math.round(vehicle.getX());
            int y = Math.round(vehicle.getY());
            moveit(vehicle, x, y);
            System.out.println(vehicles.size());
        }
        notifyObservers(vehicles);

    }


    public void moveit(Vehicle vehicle, int x, int y) {
        vehicle.point.x = x;
        vehicle.point.y = y;
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


    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers(List<Vehicle> vehicles) {
        for (Observer o:observers) {
            o.notifyUpdate(vehicles);
        }
    }
}





