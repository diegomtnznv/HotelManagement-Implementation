package e1;

public class Dirty implements RoomState {
    private static final Dirty uniqueInstance = new Dirty();

    private Dirty() {
    }
    public static Dirty instance(){return uniqueInstance;}

    @Override
    public void book(Room r, String guest) {System.out.println("Cannot book: Room is not Clean");

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
    r.setState(Clean.instance());
    System.out.println("Room cleaned by " + cleaner +", pending approval");
    }

    @Override
    public void fRoom(Room r) {
    System.out.println("Cannot free room: Room already free");
    }

    @Override
    public void cappRoom(Room r, String supervisor, boolean Approved) {
        System.out.println("Cannot approve room: Room is not clean ");

    }
}
