package Examples.BookMyShow;

import Examples.BookMyShow.model.Reservation.Reservation;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Reserved implements Delayed {
    private final Reservation reservation;
    private final Instant expiryTime;

    public Reserved(Reservation reservation) {
        this.reservation = reservation;
        this.expiryTime = Instant.now().plus(Duration.ofSeconds(15));
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getReservationId() {
        return reservation.getReservationId();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Duration remaining = Duration.between(Instant.now(), expiryTime);
        return unit.convert(remaining.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), other.getDelay(TimeUnit.MILLISECONDS));
    }

    public boolean expire() {
        return reservation.expire();
    }
}
