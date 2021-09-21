package airport;

import airport.model.Airplane;
import airport.model.Airport;
import airport.model.CargoPlane;
import airport.model.PeoplePlane;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {


        Airport airport = new Airport("Eindhoven", new Airplane[]{
                new PeoplePlane("ABC123", 30, 0, false, 600),
                new PeoplePlane("DDD888", 30, 0, false, 600),
                new PeoplePlane("ODL345", 30, 0, false, 600),
                new CargoPlane("FF2134", 15, 0, false, 600),
                new CargoPlane("PLA166", 15, 0, false, 600)
        });

        airport.printAirplanesInAirport();
        System.out.println(airport.getAnAvailablePeoplePlane());
        System.out.println(airport.getAnAvailableCargoPlane());
        System.out.println(airport.loadingAnAirplane("ABC123", 63));
        System.out.println(airport.loadingAnAirplane("FF2134", 20));
    }
}
