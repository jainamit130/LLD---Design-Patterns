package Examples.BookMyShow;

import Examples.BookMyShow.model.Reservation.Reservation;
import Examples.BookMyShow.model.Reservation.ReservationStatus;
import Examples.BookMyShow.model.Seat.Seat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ReservationService {
    private static final ReservationService reservationService = new ReservationService();
    private static final DelayQueue<Reserved> reservedQueue = new DelayQueue<>();
    private static final Map<String, Reserved> activeReservations = new ConcurrentHashMap<>();

    private ReservationService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            while(true) {
                Reserved reserved = reservedQueue.take();
                reserved.expire();
                removeActiveReservation(reserved.getReservation());
            }
        });
    }

    public static ReservationService getInstance() {
        return reservationService;
    }

    public static boolean removeReservation(Reservation reservation) {
        if(reservedQueue.remove(activeReservations.get(reservation.getReservationId()))) {
            removeActiveReservation(reservation);
            return true;
        }
        return false;
    }

    private static void removeActiveReservation(Reservation reservation) {
        activeReservations.remove(reservation.getReservationId());
    }

    private static boolean reserveInQueue(Reservation reservation) {
        Reserved reserved = new Reserved(reservation);
        activeReservations.put(reserved.getReservationId(),reserved);
        return reservedQueue.offer(reserved);
    }

    public static Reservation reserve(Reservation reservation) {
        System.out.println("Reserving...");
        for(Seat seat:reservation.getSeats()) {
            if(seat.reserve()) {
            } else {
                // release all seats
                return null;
            }
        }
        if(reserveInQueue(reservation)) reservation.setStatus(ReservationStatus.RESERVED);
        return reservation;
    }
}
