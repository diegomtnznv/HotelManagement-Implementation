package e1;

public interface RoomState {
    void book(Room r, String guest);

    void tbooking(Room r);

    void newRoom(Room r, String supervisor);
    void cRoom(Room r, String cleaner);
    void fRoom(Room r);
    void cappRoom(Room r, String supervisor,boolean Approved);


}
