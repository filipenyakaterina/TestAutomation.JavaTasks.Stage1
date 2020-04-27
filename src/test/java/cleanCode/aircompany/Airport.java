package cleanCode.aircompany;

import cleanCode.aircompany.models.MilitaryType;
import cleanCode.aircompany.planes.ExperimentalPlane;
import cleanCode.aircompany.planes.MilitaryPlane;
import cleanCode.aircompany.planes.PassengerPlane;
import cleanCode.aircompany.planes.Plane;
import java.util.*;

/**
 * @version 1.1 4-Jan-2019
 * @author Vitali Shulha
 */
public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);

        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane plane : getMilitaryPlanes()) {
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane plane : getMilitaryPlanes()) {
            if (plane.getMilitaryType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, Comparator.comparingInt(o -> o.getMaxFlightDistance()));
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, Comparator.comparingInt(o -> o.getMaxSpeed()));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, Comparator.comparingInt(o -> o.getMaxLoadCapacity()));
        return this;
    }

    private void print(Collection<? extends Plane> planes) {
        for (Plane plane:planes) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
