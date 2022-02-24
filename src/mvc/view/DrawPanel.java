package mvc.view;

import main.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage vehicleImage;

    List<Vehicle> vehicles;
    // To keep track of a single cars position
    Point vehiclePoint = new Point();


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.RED);
        //this.setBackground(new Color(1, 0, 0, (float)0.1));
        // Print an error message in case file is not found with a try/catch block

    }

    private void updateVehicleImage(Vehicle vehicle) {
        vehicleImage = vehicle.getVehicleImage();
    }


    private void updateVehiclePoint(Vehicle vehicle){
        vehiclePoint.x = vehicle.point.x;
        vehiclePoint.y = vehicle.point.y;
    }

    void updateVehicleList(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle:vehicles) {
            updateVehicleImage(vehicle);
            updateVehiclePoint(vehicle);
            g.drawImage(vehicleImage, vehiclePoint.x, vehiclePoint.y, null);
        }
        //g.drawRect(vehiclePoint.x, vehiclePoint.y, 50, 50);
    }
}
