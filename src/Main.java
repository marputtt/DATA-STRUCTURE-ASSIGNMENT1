
import java.util.LinkedList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Contact> contacts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "A":
                    addContact(contacts, scanner);
                    break;
                case "D":
                    deleteContact(contacts, scanner);
                    break;
                case "E":
                    emailSearch(contacts, scanner);
                    break;
                case "P":
                    printSearch(contacts, scanner);
                    break;
                case "S":
                    search(contacts, scanner);
                    break;
                case "Q":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        }
    private static void printMenu() {
        System.out.println("\n(A)dd, (D)elete, (E)mail search, (P)rint search, (S)earch, (Q)uit");
        System.out.print("Please enter your command: ");
    }

    private static void addContact(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);

        System.out.println("Contact added successfully.");
    }

    private static void deleteContact(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to delete: ");
        String name = scanner.nextLine();

        contacts.removeIf(contact -> contact.name.equalsIgnoreCase(name));

        System.out.println("Contact deleted successfully.");
    }

    private static void emailSearch(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Email to search: ");
        String email = scanner.nextLine();

        contacts.stream()
                .filter(contact -> contact.email.equalsIgnoreCase(email))
                .forEach(System.out::println);
    }

    private static void printSearch(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to print: ");
        String name = scanner.nextLine();

        contacts.stream()
                .filter(contact -> contact.name.equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    private static void search(LinkedList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();

        contacts.stream()
                .filter(contact -> contact.name.equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Contact not found."));
    }
}




