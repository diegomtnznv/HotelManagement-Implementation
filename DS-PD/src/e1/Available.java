package e1;

public class Available implements RoomState {
    private static final Available uniqueInstance = new Available();

    private Available() {
    }

    public static Available instance() {
        return uniqueInstance;
    }

    @Override
    public void book(Room r, String guest) {
        r.setState(Booked.instance());
        r.currentGuest = guest;
        System.out.println("Room booked by " + guest);
    }

    @Override
    public void tbooking(Room r) {
        System.out.println("Cannot terminate booking because the room is not booked yet");

    }

    @Override
    public void newRoom(Room r, String supervisor) {
        r.setState(Available.instance());
        System.out.println("New room registered by " + supervisor);

    }

    @Override
    public void cRoom(Room r, String cleaner) {
        System.out.println("Cannot clean room because it is already clean");

    }

    @Override
    public void fRoom(Room r) {
        System.out.println("Cannot proceed because room is not booked");
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
