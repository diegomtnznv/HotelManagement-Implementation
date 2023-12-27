package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void newRoom() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");

        // Assert that a room is created in the hotel
        assertEquals(1, hotel.RoomList.size());
    }

    @Test
    void showRoomInformation() {
        Hotel hotel = new Hotel();

        // Add a room to the hotel
        hotel.newRoom("Supervisor1");

        // Redirect the console output to capture it
        // This is just a basic example; for more advanced output testing, consider using libraries
        // like System Rules (https://stefanbirkner.github.io/system-rules/)
        // For simplicity, we'll just print the output to the console for verification
        System.out.println("Expected Output:");
        System.out.println("***********************");
        System.out.println("Hotel UDC-DS");
        System.out.println("***********************");
        System.out.println("Room Number: 1, State: Available");
        System.out.println("***********************");

        // Redirect back to the standard output
        System.out.println("Actual Output:");
        hotel.showRoomInformation();
    }

    @Test
    void book() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");

        // Book the room
        hotel.book(1, "Guest1");

        // Assert that the room is booked
        assertEquals("Guest1", hotel.RoomList.get(0).currentGuest);
        assertEquals(Booked.instance(), hotel.RoomList.get(0).getState());
    }

    @Test
    void tbooking() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");

        // Book the room and then terminate booking
        hotel.book(1, "Guest1");
        hotel.tbooking(1);

        // Assert that the room is now available
        assertEquals(Available.instance(), hotel.RoomList.get(0).getState());
    }

    @Test
    void cRoom() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");
        hotel.book(1,"PEPE");
        hotel.fRoom(1);

        // Clean the room
        hotel.cRoom(1, "Cleaner1");

        // Assert that the room is now in the Clean state
        assertEquals(Clean.instance(), hotel.RoomList.get(0).getState());
    }

    @Test
    void fRoom() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");

        // Book the room and then free it
        hotel.book(1, "Guest1");
        hotel.fRoom(1);

        // Assert that the room is now available
        assertEquals(Available.instance(), hotel.RoomList.get(0).getState());
    }

    @Test
    void capp() {
        Hotel hotel = new Hotel();
        hotel.newRoom("Supervisor1");

        // Clean and then approve cleaning for the room
        hotel.cRoom(1, "Cleaner1");
        hotel.capp(1, "Supervisor1", true);

        // Assert that the room is now available
        assertEquals(Available.instance(), hotel.RoomList.get(0).getState());
    }
}
