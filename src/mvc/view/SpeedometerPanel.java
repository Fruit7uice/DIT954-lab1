package mvc.view;

import main.Vehicle;

import javax.swing.*;
import java.awt.*;

public class SpeedometerPanel extends JPanel {

    JPanel speedometerPanel = new JPanel();
    CarView view;
    GridLayout grid = new GridLayout(3,1);

    public SpeedometerPanel() {
        initPanel();
    }



    void initPanel(){
        speedometerPanel.setLayout(grid);
    }



    void updateLabels(){
        speedometerPanel.removeAll();
        grid.setRows(view.vehicles.size());
        grid.setColumns(1);
        speedometerPanel.setLayout(grid);
        for (Vehicle v:view.vehicles) {
            JLabel vehicleSpeed = new JLabel(v.modelName + ": " + v.currentSpeed);
            speedometerPanel.add(vehicleSpeed);
        }
    }

    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateLabels();
        //updateView();
    }
}
