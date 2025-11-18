public class CatalogCard implements Comparable<CatalogCard> {
    private String cardID;
    private String bookTitle;
    private String bookAuthor;
    private int yearPublished;
    private String publisher;

    public CatalogCard(String cardID, String bookTitle, String bookAuthor,
            int yearPublished, String publisher) {
        this.cardID = cardID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
    }

    public String getCardID() {
        return cardID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public int compareTo(CatalogCard other) {
        return this.cardID.compareTo(other.cardID);
    }

    @Override
    public String toString() {
        return String.format("Card ID: %s\nTitle: %s\nAuthor: %s\nYear: %d\nPublisher: %s\n",
                cardID, bookTitle, bookAuthor, yearPublished, publisher);
    }
}
