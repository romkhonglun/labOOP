package Lab2.src.hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
    private int length;
    private String director;

    public Disc(String title, String category, int id, float cost, String director, int length) {
        super(title, category, id, cost);
        this.setDirector(director);
        this.setLength(length);
    }

    public Disc(String title, String category, int id, float cost) {
        super(title, category, id, cost);
    }

    public Disc(String title, float cost) {
        super(title,cost);
    }

    public int getLength() {

        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {

        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}