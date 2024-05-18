package Lab2.src.hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        DigitalVideoDisc dvd_new = new DigitalVideoDisc("The Lion King", "Animation", 87, 19.95f, "Roger Allers");
        store.addMedia(dvd_new);
        store.removeMedia(dvd_new);
    }
}
