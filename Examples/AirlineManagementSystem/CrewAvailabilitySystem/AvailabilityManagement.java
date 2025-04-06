package Examples.AirlineManagementSystem.CrewAvailabilitySystem;

import Examples.AirlineManagementSystem.entities.Airport;
import Examples.AirlineManagementSystem.entities.user.Crew;

import java.util.*;

public class AvailabilityManagement {

    private final Map<Airport, PriorityQueue<Crew>> availabilityMap;
    private final Map<String,Airport> crewAssignedAirport;

    public AvailabilityManagement(List<Crew> crews) {
        this.availabilityMap = new HashMap<>();
        this.crewAssignedAirport = new HashMap<>();
        crews.stream().forEach(crew -> {
            Airport crewSourceAirport = crew.getSource();
            crewAssignedAirport.put(crew.getCrewId(),crewSourceAirport);
            if(!availabilityMap.containsKey(crewSourceAirport)) {
                availabilityMap.put(crewSourceAirport,new PriorityQueue<>(new Comparator<Crew>() {
                    @Override
                    public int compare(Crew crew1, Crew crew2) {
                    }
                }));
            }
        });
    }
}
