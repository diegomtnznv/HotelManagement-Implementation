package e1;

public class Booked implements RoomState{
    private static final Booked uniqueInstance=new Booked();
    private Booked(){}
    public static Booked instance(){return uniqueInstance;}


    @Override
    public void book(Room r, String guest) {
        System.out.println("Cannot book room: Room is already booked");

    }

    @Override
    public void tbooking(Room r) {
        r.setState(Available.instance());
        System.out.println("Booking has been terminated");
    }

    @Override
    public void newRoom(Room r, String supervisor) {

    }

    @Override
    public void cRoom(Room r, String cleaner) {
        System.out.println("Cannot clean Room: Room is not free");

    }

    @Override
    public void fRoom(Room r) {
        r.setState(Dirty.instance());
        System.out.println("Room has been freed");

    }

    @Override
    public void cappRoom(Room r, String supervisor, boolean Approved) {
        System.out.println("Cannot approve cleaning: Room is not free");

    }
}
