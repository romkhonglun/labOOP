package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        DigitalVideoDisc dvd_new = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd_new);

    }
}
