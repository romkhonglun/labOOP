package Lab2.src.hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;
    private List<Media> itemsInStore = new ArrayList<>();

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
    private int counting = 0;

    public void addMedia(Media media) {
        if (counting < MAX_NUMBERS_STORE) {
            itemsInStore.add(media);
            counting++;
            System.out.println("The media has been added.");
        } else {
            System.out.println("No more space in store.");
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