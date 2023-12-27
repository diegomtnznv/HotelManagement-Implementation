package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AvailableTest {

    @Test
    void instance() {
        Available available1 = Available.instance();
        Available available2 = Available.instance();

        // The instance method should always return the same instance
        assertSame(available1, available2);
    }

    @Test
    void book() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to book should change the room state to Booked
        available.book(room, "Guest1");

        assertEquals(Booked.instance(), room.getState());
        assertEquals("Guest1", room.currentGuest);
    }

    @Test
    void tbooking() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to terminate booking in the Available state should have no effect
        available.tbooking(room);

        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void newRoom() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to create a new room in the Available state should have no effect
        available.newRoom(room, "Supervisor1");
    }

    @Test
    void cRoom() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to clean in the Available state should have no effect
        available.cRoom(room, "Cleaner1");

        assertEquals(Available.instance(), room.getState());


    }

    @Test
    void fRoom() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to free in the Available state should have no effect
        available.fRoom(room);

        assertEquals(Available.instance(), room.getState());

    }

    @Test
    void cappRoom() {
        Available available = Available.instance();
        Room room = new Room();

        // Attempting to approve cleaning in the Available state should change the state to Available if Approved
        available.cappRoom(room, "Supervisor1", true);

        assertEquals(Available.instance(), room.getState());



        // Attempting to deny cleaning in the Available state should change the state to Dirty if not Approved
        available.cappRoom(room, "Supervisor2", false);

        assertEquals(Dirty.instance(), room.getState());


    }
}
