import java.util.*;

//just handles user input and stuff nothing too fancy
public class CatalogSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogLogic logic = new CatalogLogic();

        while (true) {
            System.out.println("\nWelcome to the USC Library Catalog System");
            System.out.println("1. Add Catalog Card");
            System.out.println("2. Edit Catalog Card");
            System.out.println("3. Remove Catalog Card");
            System.out.println("4. View Single Catalog Card");
            System.out.println("5. View Entire Catalog");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Card ID: ");
                    String cardID = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Year Published: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();

                    logic.addCatalogCard(new CatalogCard(cardID, title, author, year, publisher));
                    break;

                case 2:
                    System.out.print("Enter Card ID to edit: ");
                    String editID = scanner.nextLine();
                    System.out.print("Enter New Book Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Book Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Year Published: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Publisher: ");
                    String newPublisher = scanner.nextLine();

                    logic.editCatalogCard(editID, newTitle, newAuthor, newYear, newPublisher);
                    break;

                case 3:
                    System.out.print("Enter Card ID to remove: ");
                    String removeID = scanner.nextLine();
                    logic.removeCatalogCard(removeID);
                    break;

                case 4:
                    System.out.print("Enter Card ID to view: ");
                    String viewID = scanner.nextLine();
                    logic.viewCatalogCard(viewID);
                    break;

                case 5:
                    logic.viewEntireCatalog();
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
