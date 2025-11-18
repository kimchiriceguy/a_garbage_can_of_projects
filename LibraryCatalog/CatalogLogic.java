import java.util.*;

public class CatalogLogic {
    private List<CatalogCard> catalog;

    public CatalogLogic() {
        catalog = new ArrayList<>();
    }

    public void addCatalogCard(CatalogCard card) {
        catalog.add(card);
        Collections.sort(catalog);
        System.out.println("Catalog card added successfully!");
    }

    // this essentially replaces the old card with updated info (notice arguments)
    // but i guess what if you want to remove just the publisher not just edit it?
    // i'm not doing that rn
    public boolean editCatalogCard(String cardID,
            String bookTitle, String bookAuthor,
            int yearPublished, String publisher) {
        for (CatalogCard card : catalog) {
            if (card.getCardID().equals(cardID)) {
                card.setBookTitle(bookTitle);
                card.setBookAuthor(bookAuthor);
                card.setYearPublished(yearPublished);
                card.setPublisher(publisher);
                System.out.println("Catalog card updated successfully!");
                return true;
            }
        }
        System.out.println("Card ID not found!");
        return false;
    }

    public boolean removeCatalogCard(String cardID) {
        // create new list without the card to be removed (i guess that's why it's
        // called an iterator..?)
        Iterator<CatalogCard> iterator = catalog.iterator();
        while (iterator.hasNext()) {
            CatalogCard card = iterator.next();
            if (card.getCardID().equals(cardID)) {
                iterator.remove();
                System.out.println("Catalog card removed successfully!");
                return true;
            }
        }
        System.out.println("Card ID not found!");
        return false;
    }

    public void viewCatalogCard(String cardID) {
        for (CatalogCard card : catalog) {
            if (card.getCardID().equals(cardID)) {
                System.out.println("\n--- Catalog Card Details ---");
                System.out.println(card);
                return;
            }
        }
        System.out.println("Card ID not found!");
    }

    public void viewEntireCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty!");
            return;
        }

        System.out.println("\nFull catalog sorted by ID:");
        for (CatalogCard card : catalog) {
            System.out.println(card);
            System.out.println("-----------------------------------");
        }
    }
}
