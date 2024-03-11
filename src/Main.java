/* Contact book using linked list - Marsya Putra - 2702367220 - Data Structure
 * 1. create a contact book program that manage your friends contact
 * (name, phone number, email ) -check
 * 2. input : The program prompts as shown in the figure
 * 3. Output : The results of the operations
 *
 * Due before week 6  */

import java.util.LinkedList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    // Constructor to initialize a Contact object with name, phone number, and email
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Overriding the toString() method to provide a custom string representation of Contact
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

// Main class that contains the main program logic
public class Main {
    public static void main(String[] args) {
        // Creating a LinkedList to store Contact objects
        LinkedList<Contact> contacts = new LinkedList<>();
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Main program loop that continues until user chooses to quit
        while (true) {
            // Printing the menu of available options
            printMenu();
            // Reading user input for the chosen command
            String command = scanner.nextLine().toUpperCase();

            // Switch statement to execute the appropriate action based on the command
            switch (command) {
                case "A":
                    addContact(contacts, scanner); // Calling method to add a new contact
                    break;
                case "D":
                    deleteContact(contacts, scanner); // Calling method to delete a contact
                    break;
                case "E":
                    emailSearch(contacts, scanner); // Calling method to search by email
                    break;
                case "P":
                    printSearch(contacts, scanner); // Calling method to print by name
                    break;
                case "S":
                    search(contacts, scanner); // Calling method to search for a contact
                    break;
                case "Q":
                    System.out.println("Exiting program..."); // Exiting the program
                    return;
                default:
                    System.out.println("Invalid command. Please try again."); // Handling invalid commands
            }
        }
    }

    // Method to print the menu of available options
    private static void printMenu() {
        System.out.println("\n(A)dd, (D)elete, (E)mail search, (P)rint search, (S)earch, (Q)uit");
        System.out.print("Please enter your command: ");
    }

    // Method to add a new contact to the LinkedList
    private static void addContact(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Creating a new Contact object with the provided details and adding it to the LinkedList
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);

        System.out.println("Contact added successfully.");
    }

    // Method to delete a contact from the LinkedList based on name
    private static void deleteContact(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to delete: ");
        String name = scanner.nextLine();

        // Using removeIf() to remove the contact if its name matches the input
        contacts.removeIf(contact -> contact.name.equalsIgnoreCase(name));

        System.out.println("Contact deleted successfully.");
    }

    // Method to search for contacts by email
    private static void emailSearch(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Email to search: ");
        String email = scanner.nextLine();

        // Using stream and filter to find contacts with matching email and printing them
        contacts.stream()
                .filter(contact -> contact.email.equalsIgnoreCase(email))
                .forEach(System.out::println);
    }

    // Method to print contacts by name
    private static void printSearch(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to print: ");
        String name = scanner.nextLine();

        // Using stream and filter to find contacts with matching name and printing them
        contacts.stream()
                .filter(contact -> contact.name.equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    // Method to search for a single contact by name
    private static void search(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();

        // Using stream and filter to find the first contact with matching name and printing it
        contacts.stream()
                .filter(contact -> contact.name.equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Contact not found."));
    }
}




