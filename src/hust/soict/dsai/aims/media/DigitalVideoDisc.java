package Lab2.src.hust.soict.dsai.aims.media;

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
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
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
















