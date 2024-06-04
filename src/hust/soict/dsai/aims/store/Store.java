package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    private int counting = 0;

    public void addMedia(Media media) throws LimitExceededException {
        if (counting < MAX_NUMBERS_STORE) {
            itemsInStore.add(media);
            counting++;
            System.out.println("The media has been added.");
        } else {
            throw new LimitExceededException("The store has reached its limit.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            counting--;
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media is not in the store.");
        }
    }

}