package Examples.AirlineManagementSystem.CrewAvailabilitySystem;

import Examples.AirlineManagementSystem.entities.Airport;
import Examples.AirlineManagementSystem.entities.user.Crew;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class AvailabilityManagement {

    private final ConcurrentHashMap<Airport, Set<Crew>> availabilityMap;

    public AvailabilityManagement() {
        this.availabilityMap = new ConcurrentHashMap<>();
    }

    private void addCrewToSource(Crew crew,Airport source) {
        availabilityMap.compute(source, ((airport, crewSet) -> {
            if(crewSet==null) crewSet = new CopyOnWriteArraySet<>();
            crewSet.add(crew);
            return crewSet;
        }));
    }

    private void removeCrewFromSource(Crew crew, Airport oldSource) {
        availabilityMap.compute(oldSource,(((airport, crewSet) -> {
            crewSet.remove(crew);
            if(crewSet.isEmpty()) return null;
            return crewSet;
        })));
    }

    public void setSourceForCrew(Crew crew, Airport oldSource, Airport newSource) {
        if(oldSource!=null) removeCrewFromSource(crew, oldSource);
        addCrewToSource(crew,newSource);
    }
}


/*
*
* 2,8  3,7   1,6  4,3  9,8
*
*
* */
