package main;

public class OrderedVehicleFactory implements IVehicleFactory {

    @Override
    public Vehicle createVehicle(Vehicle newVehicleType) {

        Vehicle newVehicle = null;

        if (newVehicleType.getClass().equals(Volvo240.class)){
            return new Volvo240();
        } else if (newVehicleType.getClass().equals(Saab95.class)){
            return new Saab95();
        } else if (newVehicleType.getClass().equals(Scania.class)) {
            return new Scania();
        } else return null;
    }

}
