package Examples.AirlineManagementSystem.CrewAvailabilitySystem;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.user.Crew;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class AvailabilityManagement {
    private static volatile AvailabilityManagement instance;
    private final ConcurrentHashMap<Airport, Set<Crew>> availabilityMap;

    private AvailabilityManagement() {
        this.availabilityMap = new ConcurrentHashMap<>();
    }

    public static AvailabilityManagement getInstance() {
        AvailabilityManagement availabilityManagement = instance;
        if(availabilityManagement == null) {
            synchronized(AvailabilityManagement.class) {
                if(instance==null) {
                    instance = new AvailabilityManagement();
                }
            }
        }
        return availabilityManagement;
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
