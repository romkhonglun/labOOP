package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category,int id, float cost,String author) {
        super(title, category, id, cost);
        this.authors.add(author);
    }

    public Book(String title, float cost) {
        super(title,cost);
    }

    public ArrayList<String> getAuthors() {
        return (ArrayList<String>) authors;
    }
    // addAuthor and removeAuthor methods
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added successfully!");}
        else {
            System.out.println("Author already exists!");}
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed successfully!");}
        else {
            System.out.println("Author does not exist!");}
    }
    @Override
    public String toString() {
        return "title:" + getTitle() +
                "| category: " + getCategory() +
                "| id: " + getId() +
                "| cost: " + getCost() +
                "| authors: " + getAuthors();

    }
}





















