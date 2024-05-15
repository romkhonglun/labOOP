package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media... media) {
        for (Media m : media) {
            itemsOrdered.add(m);
        }
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
}