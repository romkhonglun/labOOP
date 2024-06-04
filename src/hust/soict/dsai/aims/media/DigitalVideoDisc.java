package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable{
    private String directory;
    private int length;

    public DigitalVideoDisc(String title, String category, int id, float cost,String directory) {
        super(title, category, id, cost);
        this.directory = directory;
    }

    public DigitalVideoDisc(String title, float cost) {
        super(title,cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public String getDirector() {
        return this.directory;
    }

    public int getLength() {
        return this.length;
    }
    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("DVD length is non-positive!");
        }
        this.play();
    }
    @Override
    public String toString() {
        return "title:" + getTitle() +
                "| category: " + getCategory() +
                "| id: " + getId() +
                "| cost: " + getCost() +
                "| director: " + getDirector();
    }
}
















