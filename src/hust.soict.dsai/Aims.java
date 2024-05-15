package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        Media dvd1 = new DigitalVideoDisc("The lion king ","Animation", "Roger Allers",87,19.95f);
        Media dvd2 = new DigitalVideoDisc("Star war ","Science Fiction", "George Lucas ",87,24.95f);
        Media dvd3 = new DigitalVideoDisc("Aladin ","Animation", "Roger Allers",8,18.99f);

        Media[] mediaList = new Media[]{dvd1, dvd2, dvd3};
        anOrder.addMedia(mediaList);
        System.out.println("Total cost is: " + anOrder.totalCost());
    }
}