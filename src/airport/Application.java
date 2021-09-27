package airport;

import airport.builderpattern.AirportNew;
import airport.builderpattern.CargoPlaneNew;
import airport.builderpattern.PassengerPlane;
import airport.builderpattern.Plane;
import airport.model.*;
import airport.service.singeltonpattern.AirportService;

import java.util.ArrayList;
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

// Creating new instance from builderpattern package.
        Plane plane = new PassengerPlane.Builder().flightId("TK300")
                .maximumNumberOfPassengers(500)
                .currentNumberOfPassengers(200)
                .build();
        System.out.println("plane = " + plane);
        System.out.println(" plane.load(300) = " + plane.load(350));
        System.out.println("plane.unLoad() = " + plane.unLoad());
        Plane cargo = new CargoPlaneNew.Builder().flightId("CR123").maximumLoad(300).currentLoad(200).build();
        System.out.println("cargo.load(50) = " + cargo.load(50));
        System.out.println("cargo.load(100) = " + cargo.load(100));
        System.out.println("cargo.unLoad() = " + cargo.unLoad());
        System.out.println("cargo = " + cargo);

        AirportNew airportNew = new AirportNew.Builder().name("Eindhoven").planes(new ArrayList<>(Arrays.asList(
                plane,
                cargo
        ))).build();

        airportNew.printAirplanesInAirport();

        // creating service instance in singeltonpattern package.
        AirportService airportService = AirportService.getInstance();
        airportService.clean(cargo);
        AirportService airportService1 = AirportService.getInstance();
        airportService1.clean(plane);
    }
}
