package mvc.view;

import main.Vehicle;

import javax.swing.*;
import java.awt.*;

public class SpeedometerPanel extends JPanel {

    JPanel speedometerPanel = new JPanel();
    CarView view;
    GridLayout grid = new GridLayout(3,1);

    public SpeedometerPanel() {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.GREEN);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //updateLabels();
    }


}
