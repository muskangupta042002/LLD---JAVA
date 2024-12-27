package org.muskan.provider;

import lombok.NonNull;
import org.muskan.exception.SeatTemporaryUnavailableException;
import org.muskan.model.Seat;
import org.muskan.model.SeatLock;
import org.muskan.model.Show;

import java.util.*;

import com.google.common.collect.ImmutableList;

public class InMemoryLockProvider implements LockProviders{

    private final Map<Show, Map<Seat,SeatLock>> locks; //per show seat locl
    private final Integer lockTimeout;

    public InMemoryLockProvider(@NonNull final Integer lockTimeout){
        this.locks = new HashMap<>();
        this.lockTimeout = lockTimeout;
    }

    @Override
    synchronized public void lockSeats(@NonNull final Show show, @NonNull final List<Seat> seats, @NonNull final String userId) {
        for(Seat seat: seats){
            if(isSeatLocked(show, seat)){
                throw  new SeatTemporaryUnavailableException();
            }
        }

        for(Seat seat: seats){
            lockSeat(show, seat, userId, lockTimeout);
        }
    }

    @Override
    public void unlockSeats(@NonNull final Show show, @NonNull final List<Seat> seats, @NonNull final String userId) {
        for (Seat seat: seats){
            if (validateLock(show,seat,userId)){
                unlockSeat(show, seat);
            }
        }
    }

    private void unlockSeat(Show show, Seat seat) {
        if (!locks.containsKey(show)){
            return;
        }
        locks.get(show).remove(seat);
    }

    @Override
    public boolean validateLock(@NonNull final Show show, @NonNull final Seat seat, @NonNull final String userId) {
        return isSeatLocked(show, seat) && locks.get(show).get(show).getLockedBy().equals(userId);
    }

    @Override
    public List<Seat> getLockedSeats(@NonNull final Show show) {
        if (!locks.containsKey(show)){
            return ImmutableList.of();
        }
        final List<Seat> lockedSeats = new ArrayList<>();
        for (Seat seat: locks.get(show).keySet()){
            if(isSeatLocked(show,seat)){
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer timeout){
        if(!locks.containsKey(show)){
            locks.put(show, new HashMap<>());
        }
        final SeatLock lock = new SeatLock(seat, show, timeout, new Date(), user);
        locks.get(show).put(seat,lock);
    }

    private boolean isSeatLocked(final Show show, final Seat seat){
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockExpired();
    }
}
