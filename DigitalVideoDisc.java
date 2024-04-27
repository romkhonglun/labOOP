package Lab2;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String directory;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    public DigitalVideoDisc(String title, String category, String directory, int length, float cost){
        this.title = title;
        this.category = category;
        this. directory = directory;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title){
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String directory, float cost){
        this.title = title;
        this.category = category;
        this. directory = directory;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String directory,int length, float cost){
        this.title = title;
        this.category = category;
        this. directory = directory;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDirectory(){
        return this.directory;
    }

    public int getLength(){
        return this.length;
    }

    public float getCost(){
        return this.cost;
    }

    
}
