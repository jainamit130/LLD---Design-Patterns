package Examples.AirlineManagementSystem.filter;

import Examples.AirlineManagementSystem.entities.flight.State.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class FilterSystem {
    private List<Filter> filters;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public FilterSystem(List<Filter> filters) {
        this.filters = filters;
    }

    public boolean addFilter(Filter filter) {
        lock.writeLock().lock();
        try {
            return filters.add(filter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean removeFilter(Filter filter) {
        lock.writeLock().lock();
        try {
            return filters.remove(filter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Flight> filter(List<Flight> flights) {
        lock.readLock().lock();
        try {
            List<Flight> filteredFlights = new ArrayList<>(flights);
            for(Filter filter:filters) {
                filteredFlights = flights.stream().filter(filter::apply).collect(Collectors.toList());
            }
            return filteredFlights;
        } finally {
            lock.readLock().unlock();
        }
    }
}
