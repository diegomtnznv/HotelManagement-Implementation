package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirtyTest {

    @Test
    void instance() {
        Dirty dirty1 = Dirty.instance();
        Dirty dirty2 = Dirty.instance();

        // The instance method should always return the same instance
        assertSame(dirty1, dirty2);
    }

    @Test
    void book() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Attempting to book in the Dirty state should print a message and have no effect on the room state
        dirty.book(room, "Guest1");

        assertEquals(Dirty.instance(), room.getState());
        assertNull(room.currentGuest);
    }

    @Test
    void tbooking() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Attempting to terminate booking in the Dirty state should print a message and have no effect on the room state
        dirty.tbooking(room);

        assertEquals(Dirty.instance(), room.getState());
    }

    @Test
    void newRoom() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Attempting to create a new room in the Dirty state should have no effect
        dirty.newRoom(room, "Supervisor1");

        assertEquals(Dirty.instance(), room.getState());
    }

    @Test
    void cRoom() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Cleaning in the Dirty state should change the state to Clean
        dirty.cRoom(room, "Cleaner1");

        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void fRoom() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Attempting to free a room in the Dirty state should print a message and have no effect on the room state
        dirty.fRoom(room);

        assertEquals(Dirty.instance(), room.getState());
    }

    @Test
    void cappRoom() {
        Dirty dirty = Dirty.instance();
        Room room = new Room();

        // Attempting to approve cleaning in the Dirty state should print a message and have no effect on the room state
        dirty.cappRoom(room, "Supervisor1", true);

        assertEquals(Dirty.instance(), room.getState());
    }
}
