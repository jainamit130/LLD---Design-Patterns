package Examples.AirlineManagementSystem.entities.user;

import Examples.AirlineManagementSystem.CrewAvailabilitySystem.AvailabilityManagement;
import Examples.AirlineManagementSystem.entities.Airport;

import java.time.LocalDate;

public class Crew extends Staff {
    private String crewId;
    private String name;
    private Airport source;
    private LocalDate availabilityStartDate;
    private LocalDate availabilityEndDate;
    private final AvailabilityManagement availabilityManagement;

    public Crew(String crewId, String name, Airport source, LocalDate availabilityStartDate, LocalDate availabilityEndDate, AvailabilityManagement availabilityManagement) {
        this.crewId = crewId;
        this.name = name;
        this.source = source;
        this.availabilityStartDate = availabilityStartDate;
        this.availabilityEndDate = availabilityEndDate;
        this.availabilityManagement = availabilityManagement;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public void setAvailabilityStartDate(LocalDate availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public void setAvailabilityEndDate(LocalDate availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
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

    public LocalDate getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public LocalDate getAvailabilityEndDate() {
        return availabilityEndDate;
    }
}
