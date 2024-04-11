package util;

public class Room {

    // Attributes
    private String userName;
    private String email;
    private int roomNumber;

    // Constructors
    public Room() {
    }

    public Room(String userName, String email,  int roomNumber) {
        this.userName = userName;
        this.email = email;
        this.roomNumber = roomNumber;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return this.userName + ", " + this.email + ", " + this.roomNumber;
    }
}
