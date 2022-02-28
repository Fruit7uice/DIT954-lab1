package mvc.view;

import main.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawVehicle extends JPanel {

    private BufferedImage vehicleImage;
    private List<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawVehicle(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.MAGENTA);
    }

    private void updateVehicleImage(Vehicle vehicle) {
        vehicleImage = vehicle.getVehicleImage();
    }

    protected void updateVehicleList(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle:vehicles) {
            updateVehicleImage(vehicle);
            g.drawImage(vehicleImage, vehicle.getX(), vehicle.getY(), null);
        }
    }
}
