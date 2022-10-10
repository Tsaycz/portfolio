package main;

import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {

        String[] rooms = welcome();
        mainMenu(rooms);
    }
    private static String[] welcome() {

        System.out.println("Welcome to Capsule Hotel");
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of capsules available: ");
        int capsuleTotal = console.nextInt();
        console.nextLine();

        while (capsuleTotal <= 0) {
            System.out.println("Error. Please enter a valid number of capsules available: ");
            capsuleTotal = console.nextInt();
            console.nextLine();
        }
        String[] guestNames = new String[capsuleTotal];

        return guestNames;

    }

    private static void mainMenu(String[] rooms) {

        Scanner console = new Scanner(System.in);
        boolean exit = false;


        while (!exit) {

            System.out.print("1. Check In \n 2. Check Out \n 3. View Guests \n 4. Exit \n Choose on option [1-4]: ");
            int menuChoice = console.nextInt();
            console.nextLine();

            switch (menuChoice) {
                case 1:
                    checkin(rooms);
                    break;
                case 2:
                    checkout(rooms);
                    break;
                case 3:
                    viewGuests(rooms);
                    break;
                case 4:
                    System.out.println("Exit");

                    System.out.println("Are you sure you want to exist?");
                    System.out.println("All data will be lost");
                    System.out.println("To exit press y or press any other key stay:");
                    console = new Scanner(System.in);
                    String decision = console.next();

                    if (decision.equals("y")) {
                        System.out.println("Thank you for staying. Goodbye");
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }

    }

    private static void checkin(String[] rooms) {

        boolean validRoom = false;

        System.out.println("Guest Check In Name");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();

        while (!validRoom) {

            int roomNumber = getRoomNumber(rooms.length);

            if (rooms[roomNumber - 1] != null) {
                System.out.println("Occupied");
            } else {
                validRoom = true;
                rooms[roomNumber - 1] = name;
                System.out.println("Congrats " + name + " you booked into capsule number " + roomNumber);
            }
        }
    }


    private static int getRoomNumber(int length) {

        int userRoomNumber = 0;

        Scanner console = new Scanner(System.in);

        while (userRoomNumber > length || userRoomNumber <= 0) {

            System.out.println("Please enter a room number: ");
            userRoomNumber = console.nextInt();
            console.nextLine();

        }

        return userRoomNumber;
    }


    private static void checkout(String[] rooms) {

        boolean validRoom = false;

        while (!validRoom) {

            int roomNumber = getRoomNumber(rooms.length);

            if (rooms[roomNumber - 1] == null) {
                System.out.println("That is an empty room, please select another");
            } else {
                validRoom = true;
                rooms[roomNumber - 1] = null;
                System.out.println("Guest has been checked out from capsule number " + roomNumber);
            }
        }
    }

    private static void viewGuests(String[] rooms) {

        int selectedRooms = getRoomNumber(rooms.length) - 1;
        int max = selectedRooms + 5;
        int min = selectedRooms - 5;

        if (min < 0) {
            min = 0;
        }

        if (max >= rooms.length) {
            max = rooms.length - 1;
        }

        for (int i = min; i <= max; i++) {
            if (rooms[i] == null) {
                System.out.println((i + 1) + "[Unoccupied]");
            } else {
                System.out.println((i + 1) + ":" + rooms[i]);
            }
        }

    }

}
