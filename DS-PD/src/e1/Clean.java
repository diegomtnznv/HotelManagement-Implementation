package e1;

public class Clean implements RoomState {
    private static final Clean uniqueInstance = new Clean();

    private Clean() {
    }

    public static Clean instance() {
        return uniqueInstance;
    }


    @Override
    public void book(Room r, String guest) {
    System.out.println("Cannot book: Room has not been approved");
    }

    @Override
    public void tbooking(Room r) {
        System.out.println("Cannot terminate booking: Room is not booked");
    }

    @Override
    public void newRoom(Room r, String supervisor) {

    }

    @Override
    public void cRoom(Room r, String cleaner) {
    System.out.println("Cannot clean: the room is already clean");
    }

    @Override
    public void fRoom(Room r) {System.out.println("Cannot free Room: Room is already free");

    }

    @Override
    public void cappRoom(Room r, String supervisor,boolean Approved) {
        if (Approved) {
            r.setState(Available.instance());
            System.out.println("Approval granted by " + supervisor);
        } else {
            r.setState(Dirty.instance());
            System.out.println("Approval denied by " + supervisor);
        }
    }
}