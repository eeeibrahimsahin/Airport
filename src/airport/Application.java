package airport;

import airport.model.Airplane;
import airport.model.Airport;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {


        Airport airport = new Airport("Eindhoven", new Airplane[]{
                new Airplane("ABC123", 63, 0, false, 600),
                new Airplane("DDD888", 33, 0, false, 600),
                new Airplane("ODL345", 33, 0, false, 600)
        });

        airport.printAirplanesInAirport();
        System.out.println(airport.getAnAvailableAirplane());
        System.out.println(airport.loadingAnAirplane("ABC123",96));
    }
}
