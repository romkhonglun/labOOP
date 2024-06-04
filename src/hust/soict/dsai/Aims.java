package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.util.*;

public class Aims {
    static Store store = new Store();
    static Cart cart = new Cart();
    static Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See cart");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                storeMenu();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                cartMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
        sc.close();
    }
    public static void storeMenu () {
        System.out.println("Store menu: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See the current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                mediaDetailsMenu();
                break;
            case 2:
                addToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                currentCart();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }
    public static void mediaDetailsMenu (){
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                addToCart();
            case 2:
                playMedia();
                break;
            case 0:
                storeMenu();
                break;
            default:
                break;
        }
        sc.close();
    }
    public static void addToCart() {
        System.out.println("Enter the title of the media: ");
        Scanner sc = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(sc.nextLine());
        Cart anOrder = new Cart();
        anOrder.addMedia(dvd);
        System.out.println("Added to cart.");
        sc.close();
    }

    public static void playMedia() {
        System.out.println("Enter the title of the media: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        // Search for the media in the store
        Media mediaToPlay = null;
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                mediaToPlay = media;
                break;
            }
        }
        // If the media was found, check its type
        if (mediaToPlay != null) {
            if (mediaToPlay instanceof Book) {
                System.out.println("Cannot play a book.");
            } else if (mediaToPlay instanceof CompactDisc) {
                try {
                    ((CompactDisc) mediaToPlay).play();
                } catch (PlayerException e) {
                    System.err.println("ERROR: Cannot play media!");
                    System.err.println("Reason: " + e.getMessage());
                    e.printStackTrace();
                    // Display a dialog box to the user with the content of the exception
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else if (mediaToPlay instanceof DigitalVideoDisc) {
                try {
                    ((DigitalVideoDisc) mediaToPlay).play();
                } catch (PlayerException e) {
                    System.err.println("ERROR: Cannot play media!");
                    System.err.println("Reason: " + e.getMessage());
                    e.printStackTrace();
                    // Display a dialog box to the user with the content of the exception
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                System.out.println("Unknown media type.");
            }
        } else {
            System.out.println("Media with the given title was not found.");
        }

        sc.close();
    }


    public static void updateStore() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                addToCart();
                break;
            case 2:
                playMedia();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }
    public static void removeMediaFromStore() {
        System.out.println("Enter the title of the media: ");
        Scanner sc = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(sc.nextLine());
        store.removeMedia(dvd);
        System.out.println("Removed from store.");
        sc.close();
    }
    public static void cartMenu () {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                filterMediaInCart();
                break;
            case 2:
                sortMediaInCart();
                break;
            case 3:
                removeFromCart();
                break;
            case 4:
                playMedia();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }

    private static void removeFromCart() {
        System.out.println("Enter the title of the media: ");
        Scanner sc = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(sc.nextLine());
        cart.removeMedia(dvd);
        System.out.println("Removed from cart.");
        sc.close();
    }

    public static void filterMediaInCart() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by category");
        System.out.println("3. Filter by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                filterByTitle();
                break;
            case 2:
                filterById();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }
    public static void filterByTitle() {
        System.out.println("Enter the title: ");
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        List<Media> allres = new ArrayList<>();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().contains(res)) {
                allres.add(media);
                System.out.print(media.toString());
            }
            else {
                System.out.println("No media found.");
            }
        }
    }
    public static void filterById() {
        System.out.println("Enter the category: ");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        List<Media> allres = new ArrayList<>();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getId() == res) {
                allres.add(media);
                System.out.print(media.toString());
            }else {
                System.out.println("No media found.");
            }
        }
    }
    public static void sortMediaInCart() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by category");
        System.out.println("3. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 1:
                sortByTitle(cart);
                break;
            case 2:
                sortByCost(cart);
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }
    public static void sortByTitle(Cart anOrder) {
        Collections.sort(anOrder.getItemsOrdered(), new Comparator<Media>() {
            @Override
            public int compare(Media o1, Media o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        System.out.println("List sorted by title: "+ anOrder.getItemsOrdered());
    }
    public static void sortByCost(Cart anOrder) {
        Collections.sort(anOrder.getItemsOrdered(), new Comparator<Media>() {
            @Override
            public int compare(Media o1, Media o2) {
                return Float.compare(o1.getCost(), o2.getCost());
            }
        });
        System.out.println("List sorted by cost: "+ anOrder.getItemsOrdered());
    }
    public static void placeOrder() {
        currentCart();
        System.out.println("Order created");
    }
    private static void currentCart() {
        System.out.println("Current cart: ");
        System.out.println(cart.toString());
    }
    public static void main (String[]args){

        showMenu();
    }
}























