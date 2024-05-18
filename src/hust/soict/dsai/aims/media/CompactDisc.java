package Lab2.src.hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, int id, float cost,String artist) {
        super(title, category, id, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, float cost) {
        super(title,cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the list.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "title:" + getTitle() +
                "| category: " + getCategory() +
                "| id: " + getId() +
                "| cost: " + getCost() +
                "| artist: " + getArtist();
    }
}




















