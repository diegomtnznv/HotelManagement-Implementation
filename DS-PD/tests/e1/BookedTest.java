package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookedTest {

    @Test
    void instance() {
        Booked booked1 = Booked.instance();
        Booked booked2 = Booked.instance();

        // The instance method should always return the same instance
        assertSame(booked1, booked2);
    }

    @Test
    void book() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Attempting to book in the Booked state should print a message and have no effect on the room state
        booked.book(room, "Guest1");

        assertEquals(Booked.instance(), room.getState());
        assertNull(room.currentGuest);
    }

    @Test
    void tbooking() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Terminating booking in the Booked state should change the room state to Available
        booked.tbooking(room);

        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void newRoom() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Attempting to create a new room in the Booked state should have no effect
        booked.newRoom(room, "Supervisor1");

        assertEquals(Booked.instance(), room.getState());
    }

    @Test
    void cRoom() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Attempting to clean in the Booked state should print a message and have no effect on the room state
        booked.cRoom(room, "Cleaner1");

        assertEquals(Booked.instance(), room.getState());
    }

    @Test
    void fRoom() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Freeing a room in the Booked state should change the state to Dirty
        booked.fRoom(room);

        assertEquals(Dirty.instance(), room.getState());
    }

    @Test
    void cappRoom() {
        Booked booked = Booked.instance();
        Room room = new Room();

        // Attempting to approve cleaning in the Booked state should print a message and have no effect on the room state
        booked.cappRoom(room, "Supervisor1", true);

        assertEquals(Booked.instance(), room.getState());
    }
}
