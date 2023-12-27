package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getRoomNumber() {
        Room room = new Room();
        assertEquals(1, room.getRoomNumber());
    }

    @Test
    void book() {
        Room room = new Room();
        room.book("Guest1");

        // Assert that the room is booked
        assertEquals("Guest1", room.currentGuest);
        assertEquals(Booked.instance(), room.getState());
    }

    @Test
    void tbooking() {
        Room room = new Room();

        // Book the room and then terminate booking
        room.book("Guest1");
        room.tbooking();

        // Assert that the room is now available
        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void newRoom() {
        Room room = new Room();
        room.newRoom("Supervisor1");

        // Assert that the room state is still available
        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void cRoom() {
        Room room = new Room();

        // Clean the room
        room.cRoom("Cleaner1");

        // Assert that the room is now in the Clean state
        assertEquals(Clean.instance(), room.getState());
    }

    @Test
    void fRoom() {
        Room room = new Room();

        // Book the room and then free it
        room.book("Guest1");
        room.fRoom();

        // Assert that the room is now available
        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void cappRoom() {
        Room room = new Room();

        // Clean and then approve cleaning for the room
        room.cRoom("Cleaner1");
        room.cappRoom("Supervisor1", true);

        // Assert that the room is now available
        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void getState() {
        Room room = new Room();
        assertEquals(Available.instance(), room.getState());
    }

    @Test
    void setState() {
        Room room = new Room();
        room.setState(Booked.instance());

        // Assert that the state is set correctly
        assertEquals(Booked.instance(), room.getState());
    }

    @Test
    void testToString() {
        Room room = new Room();
        room.book("Guest1");

        // Assert that the toString() method produces the expected output
        assertEquals("e1.Room no. 1: e1.Booked: e1.Booked by Guest1. Occupied.", room.toString());
    }
}
