package Lab2.src.hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 87, 19.95f, "Roger Allers");
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 97, 24.95f, "George Lucas");
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 90, 18.99f, "John Musker");
        cart.addMedia(dvd3);

        System.out.println("Total cost is: " + cart.totalCost());
    }
}
