package airport.service.singeltonpattern;

import airport.builderpattern.Plane;

public class AirportService {
    private static AirportService airportService_Instance = null;

    private AirportService() {

    }

    public static AirportService getInstance() {
        if (airportService_Instance == null)
            airportService_Instance = new AirportService();
        return airportService_Instance;
    }

    public void clean(Plane plane) {
        System.out.println(this.hashCode() + " is cleaning " + plane.hashCode());
    }
}