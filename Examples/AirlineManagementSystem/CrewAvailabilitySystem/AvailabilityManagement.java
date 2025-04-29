package Examples.AirlineManagementSystem.CrewAvailabilitySystem;

import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.flight.State.Flight;
import Examples.AirlineManagementSystem.entities.user.Crew;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class AvailabilityManagement {
    private static volatile AvailabilityManagement instance;
    private final ConcurrentHashMap<Airport, Set<Crew>> availabilityMap;
    private final Set<Crew> availableCrews;

    private AvailabilityManagement() {
        this.availableCrews = new CopyOnWriteArraySet<>();
        this.availabilityMap = new ConcurrentHashMap<>();
    }

    public static AvailabilityManagement getInstance() {
        AvailabilityManagement availabilityManagement = instance;
        if(availabilityManagement == null) {
            synchronized(AvailabilityManagement.class) {
                availabilityManagement = instance;
                if(availabilityManagement==null) {
                    instance = availabilityManagement = new AvailabilityManagement();
                }
            }
        }
        return availabilityManagement;
    }

    public boolean allocateAvailableCrew(Flight flight) {
        Optional<Crew> availableCrew = availableCrews.stream().findAny();
        if(availableCrew.isPresent()) flight.addCrew(availableCrew.get());
        return availableCrew.isPresent();
    }

    public boolean allocateCrewToFlight(Flight flight) {
        Airport source = flight.getSource();
        Set<Crew> crewSet = availabilityMap.get(source);

        if (crewSet == null || crewSet.isEmpty()) {
            return false;
        }

        synchronized (crewSet) {
            Iterator<Crew> iterator = crewSet.iterator();
            if (iterator.hasNext()) {
                Crew crew = iterator.next();
                iterator.remove();
                flight.addCrew(crew);
                return true;
            }
        }

        return false;
    }


    private void addCrewToSource(Crew crew, Airport source) {
        availabilityMap.compute(source, (airport, crewSet) -> {
            if (crewSet == null) {
                crewSet = Collections.synchronizedSet(new HashSet<>());
            }
            crewSet.add(crew);
            availableCrews.add(crew);
            return crewSet;
        });
    }


    private void removeCrewFromSource(Crew crew, Airport oldSource) {
        availabilityMap.compute(oldSource,(((airport, crewSet) -> {
            crewSet.remove(crew);
            availableCrews.remove(crew);
            if(crewSet.isEmpty()) return null;
            return crewSet;
        })));
    }

    public synchronized void setSourceForCrew(Crew crew, Airport oldSource, Airport newSource) {
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
