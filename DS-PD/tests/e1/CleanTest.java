package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CleanTest {

    @Test
    void instance() {
        Clean clean1 = Clean.instance();
        Clean clean2 = Clean.instance();

        // The instance method should always return the same instance
        assertSame(clean1, clean2);
    }

    @Test
    void book() {
        Clean clean = Clean.instance();
        Room room = new Room();

        // Attempting to book in the Clean state should print a message and have no effect on the room state
        clean.book(room, "Guest1");

        assertEquals(Clean.instance(), room.getState());
        assertNull(room.currentGuest);
    }

    @Test
    void tbooking() {
        Clean clean = Clean.instance();
        Room room = new Room();

        // Attempting to terminate booking in the Clean state should print a message and have no effect on the room state
        clean.tbooking(room);

        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void newRoom() {

        Room room = new Room();
        Clean clean = Clean.instance();

        // Attempting to create a new room in the Clean state should have no effect
        clean.newRoom(room, "Supervisor1");

        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void cRoom() {
        Clean clean = Clean.instance();
        Room room = new Room();

        // Attempting to clean in the Clean state should print a message and have no effect on the room state
        clean.cRoom(room, "Cleaner1");

        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void fRoom() {
        Clean clean = Clean.instance();
        Room room = new Room();

        // Attempting to free a room in the Clean state should print a message and have no effect on the room state
        clean.fRoom(room);

        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void cappRoom() {
        Clean clean = Clean.instance();
        Room room = new Room();

        // Approving cleaning in the Clean state should change the state to Available
        clean.cappRoom(room, "Supervisor1", true);

        assertEquals(Available.instance(), room.getState());
    }
}
