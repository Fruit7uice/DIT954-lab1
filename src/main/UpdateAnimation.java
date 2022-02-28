package main;

import main.*;
import mvc.Observer;
import mvc.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpdateAnimation implements ActionListener {

    private final List<Observer> observers = new ArrayList<>();


    // The frame that represents this instance View of the MVC pattern
    //CarView frame;

    //EventHandler eventHandler = new EventHandler();
    private final List<Collidable> collidables;

    private final List<Vehicle> vehicles;

    public UpdateAnimation(List<Vehicle> vs, List<Collidable> collidables) {
        vehicles = vs;
        this.collidables = collidables;
        // The timer is started with a listener (see below) that executes the statements
        // each step between delays.
        // The delay (ms) corresponds to 20 updates a sec (hz)
        int delay = 50;
        Timer timer = new Timer(delay, this);
        timer.start();
    }


    private void update(){
        for (Vehicle vehicle : vehicles) {
            validateCollision(vehicle, collidables);
            vehicle.move();
        }

        notifyObservers(getVehicles());
    }

    private void validateCollision(Vehicle vehicle, List<Collidable> collidables) {
        for (Collidable c:collidables) {
            vehicle.vehicleCollision(vehicle, c);
        }

    }

    public List<Vehicle> getVehicles(){
        return new ArrayList<>(vehicles);
    }

    //Observer methods.

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





