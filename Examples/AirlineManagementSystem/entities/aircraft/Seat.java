package Examples.AirlineManagementSystem.entities.aircraft;

import Examples.AirlineManagementSystem.entities.enums.SeatType;
import Examples.AirlineManagementSystem.entities.enums.SeatStatus;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Seat {
    private final ReentrantLock lock;
    private final String seatId;
    private final Aircraft aircraft;
    private final SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(String seatId, Aircraft aircraft, SeatType seatType) {
        this.seatId = seatId;
        this.aircraft = aircraft;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.VACANT;
        this.lock = new ReentrantLock();
    }

    private void releaseSeat() { seatStatus = SeatStatus.VACANT; }

    private void reserveSeat() { seatStatus = SeatStatus.RESERVED; }

    private void bookSeat() { seatStatus = SeatStatus.OCCUPIED; }

    private ReentrantLock getLock() { return lock; }

    public String getId() {return seatId;}

    public double getPrice() {
        return aircraft.getSeatPrice(this);
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isVacant() {
        return seatStatus.equals(SeatStatus.VACANT);
    }

    public static boolean reserveSeats(List<Seat> requestedSeats) {
        requestedSeats.sort(Comparator.comparing(Seat::getId));

        // Lock all seats
        for (Seat seat : requestedSeats) {
            seat.getLock().lock();
        }

        try {
            for (Seat seat : requestedSeats) {
                if (!seat.isVacant()) {
                    System.out.println("Seat :" + seat.getId() + " is not vacant!");
                    return false;
                }
            }

            for (Seat seat : requestedSeats) {
                seat.reserveSeat();
            }

            return true;
        } finally {
            for (Seat seat : requestedSeats) {
                seat.getLock().unlock();
            }
        }
    }

    public static boolean releaseSeats(List<Seat> seatsToRelease) {
        seatsToRelease.sort(Comparator.comparing(Seat::getId));
        for (Seat seat : seatsToRelease) {
            seat.getLock().lock();
        }

        try {
            for (Seat seat : seatsToRelease) {
                seat.releaseSeat();
            }

            return true;
        } finally {
            for (Seat seat : seatsToRelease) {
                seat.getLock().unlock();
            }
        }
    }

    public static boolean bookSeats(List<Seat> seatsToBook) {
        seatsToBook.sort(Comparator.comparing(Seat::getId));
        for (Seat seat : seatsToBook) {
            seat.getLock().lock();
        }

        try {
            for (Seat seat : seatsToBook) {
                seat.bookSeat();
            }

            return true;
        } finally {
            for (Seat seat : seatsToBook) {
                seat.getLock().unlock();
            }
        }
    }
}
