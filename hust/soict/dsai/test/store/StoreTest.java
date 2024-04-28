package Lab2.hust.soict.dsai.test.store;
import Lab2.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import Lab2.hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        DigitalVideoDisc dvd_new = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd_new);
        store.removeDVD(dvd_new);
    }
}
