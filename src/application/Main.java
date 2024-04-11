package application;

import util.Room;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean exit = false;

        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();

        System.out.println("========== HOTEL CALIFORNIA ==========\n");

        while (!exit) {

            System.out.print("\n[1] Rent a room\n[2] Vacate a room\n[3] Show used rooms\n[0] Exit\n--> ");

            try {
                int option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("\nEnter renter's name: ");
                        String renterName = sc.nextLine();

                        System.out.print("Enter renter's email: ");
                        String renterEmail = sc.nextLine();

                        System.out.print("Enter room number: ");
                        int room = 0;
                        try {
                            room = Integer.parseInt(sc.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input format for room number.");
                        }

                        if (checkIfOccupied(rooms, room)) {
                            while (checkIfOccupied(rooms, room)) {
                                System.out.print("\nThe room " + room + " is already occupied. Try another one: ");
                                try {
                                    room = Integer.parseInt(sc.nextLine());
                                } catch (InputMismatchException e) {
                                    System.out.println("\nInvalid input for room number.");
                                }
                            }
                        }
                        rooms.add(new Room(renterName, renterEmail, room));
                        System.out.println("\nRoom rented successfully by " + renterName);

                        break;
                    case 2:
                        if (rooms.isEmpty()) {
                            System.out.println("There are no used rooms.");
                        } else {
                            System.out.print("\nEnter room number to be vacated: ");
                            int roomNumber = 0;

                            try {
                                roomNumber = Integer.parseInt(sc.nextLine());
                            } catch (InputMismatchException e) {
                                System.out.println("\nInvalid input for room number.");
                            }

                            if (removeRoom(rooms, roomNumber)) {
                                System.out.println("Room vacated successfully.");
                            } else {
                                System.out.println("Invalid room number.");
                            }
                        }

                        break;
                    case 3:
                        showUsedRooms(rooms);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("\nInvalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid numeric option.");
            }
        }

        System.out.println("\nCome back to Hotel California soon!");

        sc.close();
    }

    // Show used rooms
    public static void showUsedRooms(ArrayList<Room> roomArrayList) {
        int cont = 1;

        if (roomArrayList.isEmpty()) {
            System.out.println("\nThere are no used rooms.");
        } else {
            System.out.println();
            for (Room r : roomArrayList) {
                System.out.println(cont + "#: " + r);
                cont++;
            }
        }
    }

    // Checks if the ArrayList contains an instance with the attribute "roomNumber" that equals the roomNumber argument
    public static boolean checkIfOccupied(ArrayList<Room> roomArrayList, int roomNumber) {
        for (Room r : roomArrayList) {
            if (r.getRoomNumber() == roomNumber) {
                return true;
            }
        }
        return false;
    }

    // Remove an instance from the ArrayList if it is not empty
    public static boolean removeRoom(ArrayList<Room> roomArrayList, int roomNumber) {
        if (roomArrayList.isEmpty()) {
            return false;
        } else {
            for (Room r : roomArrayList) {
                if (r.getRoomNumber() == roomNumber) {
                    roomArrayList.remove(r);
                    return true;
                }
            }
        }
        return false;
    }
}
