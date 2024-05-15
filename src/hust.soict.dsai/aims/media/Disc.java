package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
    private int length;
    private String director;

    public Disc(String title) {
        super();
        setTitle(title);
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}