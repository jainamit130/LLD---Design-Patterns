package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.CrewAvailabilitySystem.AvailabilityManagement;
import Examples.AirlineManagementSystem.entities.flight.Airport;

import java.time.LocalDate;

public class Crew extends Staff {
    private String crewId;
    private String name;
    private Airport source;
    private final AvailabilityManagement availabilityManagement;

    public Crew(String userId, String name, Account account,Airport source) {
        super(userId,name,account);
        this.crewId = crewId;
        this.name = name;
        this.source = source;
        this.availabilityManagement = AvailabilityManagement.getInstance();
        this.availabilityManagement.setSourceForCrew(this,null,this.source);
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(Airport source) {
        Airport oldSource = getSource();
        this.source = source;
        availabilityManagement.setSourceForCrew(this,oldSource,source);
    }

    public String getCrewId() {
        return crewId;
    }

    public String getName() {
        return name;
    }

    public Airport getSource() {
        return source;
    }

}
