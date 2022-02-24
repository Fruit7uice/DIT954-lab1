package mvc;

import main.Vehicle;

import java.util.List;

public interface Observer {

    void notifyUpdate(List<Vehicle> vehicles);
}
