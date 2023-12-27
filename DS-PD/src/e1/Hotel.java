package e1;

import java.util.ArrayList;
import java.util.List;

public class Hotel { //Composite pattern used
    List<Room> RoomList = new ArrayList<>();

    public void newRoom(String supervisor) {
        Room newRoom = new Room();
        RoomList.add(newRoom);
        System.out.println("Room " + newRoom.getRoomNumber() + " created by " + supervisor);
    }

    public void showRoomInformation() {
        System.out.println("***********************");
        System.out.println("Hotel UDC-DS");
        System.out.println("***********************");
        for (Room room : RoomList) {
            System.out.println(room.toString());
        }
        System.out.println("***********************");
    }

    public void book(int roomNumber, String guest) {
        Room roomToBook = getRoomByNumber(roomNumber);
        if (roomToBook != null) {
            roomToBook.book(guest);
        } else {
            System.out.println("Room not found.");
        }
    }

    public void tbooking(int roomNumber) {
        Room roomToTerminateBooking = getRoomByNumber(roomNumber);
        if (roomToTerminateBooking != null) {
            roomToTerminateBooking.tbooking();
        } else {
            System.out.println("Room not found.");
        }
    }

    public void cRoom(int roomNumber, String cleaner) {
        Room roomToClean = getRoomByNumber(roomNumber);
        if (roomToClean != null) {
            roomToClean.cRoom(cleaner);
        } else {
            System.out.println("Room not found.");
        }
    }
    public void fRoom(int roomNumber) {
        Room roomToFree = getRoomByNumber(roomNumber);
        if (roomToFree != null) {
            roomToFree.fRoom();
        } else {
            System.out.println("Room not found.");
        }
    }

    public void capp(int roomNumber, String supervisor, boolean approved) {
        Room roomToApproveCleaning = getRoomByNumber(roomNumber);
        if (roomToApproveCleaning != null) {
            roomToApproveCleaning.cappRoom(supervisor, approved);
        } else {
            System.out.println("Room not found.");
        }
    }

    private Room getRoomByNumber(int roomNumber) {
        return RoomList.stream()
                .filter(room -> room.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }
}
