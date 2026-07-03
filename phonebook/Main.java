import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        int choice = 0;

        do {
            System.out.println("\n===== PHONE BOOK =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    phoneBook.put(name, phone);
                    System.out.println("Contact Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    String search = scanner.nextLine();

                    if (phoneBook.containsKey(search)) {
                        System.out.println("Phone Number: " + phoneBook.get(search));
                    } else {
                        System.out.println("Contact Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String delete = scanner.nextLine();

                    if (phoneBook.containsKey(delete)) {
                        phoneBook.remove(delete);
                        System.out.println("Contact Deleted.");
                    } else {
                        System.out.println("Contact Not Found.");
                    }
                    break;

                case 4:
                    if (phoneBook.isEmpty()) {
                        System.out.println("Phone Book is Empty.");
                    } else {
                        System.out.println("\nContacts:");
                        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}