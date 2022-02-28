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

    private List<Observer> observers = new ArrayList<>();

    // The frame that represents this instance View of the MVC pattern
    //CarView frame;

    //DrawPanel drawPanel;

    //EventHandler eventHandler = new EventHandler();
    public List<Collidable> collidables;

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


    private void update(){
        for (Vehicle vehicle : vehicles) {
            validateCollision(vehicle, collidables);
            vehicle.move();

            int x = Math.round(vehicle.getX());
            int y = Math.round(vehicle.getY());
            moveit(vehicle, x, y);
            //System.out.println(vehicles.size());
        }

        notifyObservers(vehicles);
    }


    private void moveit(Vehicle vehicle, int x, int y) {
        vehicle.point.x = x;
        vehicle.point.y = y;
    }

    private void validateCollision(Vehicle vehicle, List<Collidable> collidables) {
        for (Collidable c:collidables) {
            //Vehicle temp = new Volvo240((int) (vehicle.getX()+(1* vehicle.getdX())), (int) (vehicle.getY() + (1* vehicle.getdY())));
            vehicle.vehicleCollision(vehicle, c);
            /*
            if (temp.intersects(c)) { // vehicle.isCollisionWithWalls()
                System.out.println(vehicle.latestCollision);
                //System.out.println("Collision detected");
                vehicle.stopEngine();
                vehicle.collisionBehavior(vehicle);

                vehicle.startEngine();

            }

             */
        }

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





