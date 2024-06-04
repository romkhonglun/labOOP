package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public void addMedia(Media... media) {
        if (itemsOrdered.size() + media.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            for (Media m : media) {
                itemsOrdered.add(m);
                System.out.println("The media has been added");            }        }    }

    public void removeMedia(Media media) {

        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the cart");        }    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();        }
        return total;    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void searchTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                System.out.println(media.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Media not found in cart.");
        }
    }
}