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

        for (Airplane airplane : airport.getAirplanes()) {
            if (airplane instanceof PeoplePlane)
                ((PeoplePlane) airplane).sayHelloFromPeoplePlane();
            else if (airplane instanceof CargoPlane)
                ((CargoPlane) airplane).sayHelloFromCargoPlane();
        }
    }
}
