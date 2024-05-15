package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable{
    private String directory;
    private int length;

    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String directory, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.directory = directory;
    }

    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.directory = directory;
        this.length = length;
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

}