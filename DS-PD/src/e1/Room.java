package e1;

public class Room{

        private static int roomCounter = 0;
        private int roomNumber;

        public Room() {
                roomCounter++;
                roomNumber = roomCounter;
        }

        public int getRoomNumber() {
                return roomNumber;
        }
        RoomState state= Available.instance();
        String currentGuest;
        public void book(String guest){
                state.book(this,guest);
        }
        public void tbooking(){
                state.tbooking(this);
        }

        public void newRoom(String supervisor){state.newRoom(this,supervisor);};
        public void cRoom(String cleaner){state.cRoom(this,cleaner);}
        public void fRoom() {state.fRoom(this);}
        public void cappRoom (String supervisor,boolean Approved){state.cappRoom(this,supervisor,Approved);}

        public RoomState getState () {
                return state;
        }
        public void setState (RoomState state){
                this.state = state;
        }
        public String toString() {
                String condition;
                if (state == Available.instance()) {
                        condition = "Free.";
                } else if (state == Clean.instance()) {
                        condition = "Clean: Room cleaned by " + currentGuest + ", pending approval.";
                } else if (state == Dirty.instance()) {
                        condition = "Dirty: Cleaning pending.";
                } else if (state == Booked.instance()) {
                        condition = "Booked: Booked by " + currentGuest + ". Occupied.";
                } else {
                        condition = "Unknown condition.";
                }
                return "Room no. " + roomNumber + ": " + condition;
        }
}


