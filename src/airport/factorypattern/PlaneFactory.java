package airport.factorypattern;

import airport.builderpattern.CargoPlaneNew;
import airport.builderpattern.PassengerPlane;
import airport.builderpattern.Plane;

public class PlaneFactory {
    public static Plane getPlane(String type) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("PASSENGERPLANE"))
            return new PassengerPlane.Builder().build();
        else if (type.equalsIgnoreCase("CARGOPLANE"))
            return new CargoPlaneNew.Builder().build();

        return null;
    }

    public static Plane getPlane(String type, String id) {
        if (type == null)
            return null;
        if (type.equalsIgnoreCase("PASSENGERPLANE"))
            return new PassengerPlane.Builder().flightId(id).build();
        else if (type.equalsIgnoreCase("CARGOPLANE"))
            return new CargoPlaneNew.Builder().flightId(id).build();

        return null;

    }
}
