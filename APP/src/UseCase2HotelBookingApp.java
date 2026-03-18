/** MAIN CLASS-UseCase2HotelBookingApp
 * Use Case 2 :Basic Room Types & Static Availability
 *
 * @author Developer
 * @version 2.0
 */
abstract class UseCase2HotelBookingApp {

    protected String roomType;
    protected double price;
    protected boolean available;

    public UseCase2HotelBookingApp(String roomType, double price, boolean available) {
        this.roomType = roomType;
        this.price = price;
        this.available = available;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + available);
    }
}

class SingleRoom extends UseCase2HotelBookingApp {

    public SingleRoom() {
        super("Single Room", 1000, true);
    }
}

class DoubleRoom extends UseCase2HotelBookingApp {

    public DoubleRoom() {
        super("Double Room", 1800, true);
    }
}

class SuiteRoom extends UseCase2HotelBookingApp {

    public SuiteRoom() {
        super("Suite Room", 3000, true);
    }
}
class TestRooms {

    public static void main(String[] args) {

        UseCase2HotelBookingApp r1 = new SingleRoom();
        UseCase2HotelBookingApp r2 = new DoubleRoom();
        UseCase2HotelBookingApp r3 = new SuiteRoom();

        r1.displayDetails();
        System.out.println();

        r2.displayDetails();
        System.out.println();

        r3.displayDetails();
    }
}

