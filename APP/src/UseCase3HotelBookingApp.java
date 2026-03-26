package src;

/** MAIN CLASS-UseCase2HotelBookingApp
 * Use Case 3:Centralized Room Inventory Management
 *
 * @author Developer
 * @version 3.0
 */
import java.util.Map;
import java.util.HashMap;

// RoomInventory class (separate class)
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room types
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
        System.out.println(roomType + " rooms added with count: " + count);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int change) {
        if (!inventory.containsKey(roomType)) {
            System.out.println("Room type not found!");
            return;
        }

        int current = inventory.get(roomType);
        int updated = current + change;

        if (updated < 0) {
            System.out.println("Not enough rooms available!");
        } else {
            inventory.put(roomType, updated);
            System.out.println(roomType + " updated. New count: " + updated);
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}


// Main class
public class UseCase3HotelBookingApp {
    public static void main(String[] args) {

        // Initialize system
        RoomInventory inventory = new RoomInventory();

        // Register rooms
        inventory.addRoomType("Single", 10);
        inventory.addRoomType("Double", 5);
        inventory.addRoomType("Suite", 2);

        // Display inventory
        inventory.displayInventory();

        // Simulate booking
        inventory.updateAvailability("Single", -3);

        // Simulate cancellation
        inventory.updateAvailability("Double", 2);

        // Check availability
        System.out.println("\nAvailable Single rooms: " +
                inventory.getAvailability("Single"));

        // Final state
        inventory.displayInventory();
    }
}