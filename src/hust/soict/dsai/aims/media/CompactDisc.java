package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("CD length is non-positive!");
        }

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println("ERROR: Cannot play track: " + track.getTitle());
                System.err.println("Reason: " + e.getMessage());
            }
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




















