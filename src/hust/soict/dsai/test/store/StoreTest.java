package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;
public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",  87, 19.95f, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",  87, 24.95f, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",  87, 18.99f, "John Musker");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation",  87, 19.95f, "Roger Allers");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars", "Science Fiction",  87, 24.95f, "George Lucas");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin", "Animation",  87, 18.99f, "John Musker");
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion King", "Animation",  87, 19.95f, "Roger Allers");
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Star Wars", "Science Fiction",  87, 24.95f, "George Lucas");
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Aladin", "Animation",  87, 18.99f, "John Musker");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(dvd7);
        store.addMedia(dvd8);
        store.addMedia(dvd9);

        new StoreScreen(store);
    }
}
