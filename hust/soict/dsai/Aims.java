package Lab2.hust.soict.dsai;

import Lab2.hust.soict.dsai.aims.cart.Cart;
import Lab2.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king ","Animation", "Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star war ","Science Fiction", "George Lucas ",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin ","Animation", "Roger Allers",8,18.99f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // anOrder.removeDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: " + anOrder.totalCost());
    }
}
