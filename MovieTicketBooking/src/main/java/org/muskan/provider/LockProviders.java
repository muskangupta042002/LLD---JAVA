package org.muskan.provider;

import org.muskan.model.Seat;
import org.muskan.model.Show;

import java.util.List;

public interface LockProviders {
    //can be redis, or in-memory
    void lockSeats(Show show, List<Seat>seats, String userId);
    void unlockSeats(Show show, List<Seat>seats, String userId);
    boolean validateLock(Show show, Seat seat, String userId);

    List<Seat> getLockedSeats(Show show);
}
