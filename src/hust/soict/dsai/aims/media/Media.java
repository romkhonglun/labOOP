package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


    public Media(String title, String category,int id, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setId(id);
        this.setCost(cost);
    }

    public Media(String title, float cost) {
        this.setTitle(title);
        this.setCost(cost);
    }

    public Media(String title) {
        this.setTitle(title);
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object obj) {
        try{
            if (this == obj) {
                return true;
            }
            if (obj instanceof Media) {
                return false;
         }
        Media media = (Media) obj;
        return media.getTitle().equals(this.getTitle());
        } catch(NullPointerException e) {
            System.out.println("Error: NullPointerException");
            return false;
        }catch(ClassCastException e) {
            System.out.println("Error: ClassCastException");
            return false;
        }
    }
    @Override
    public String toString(){
        String res = "Media: ";
        if (getTitle() != null) {
            res += getTitle();
        }
        if (getCategory() != null) {
            res += " - " + getCategory();
        }
        if (getCost() != 0.0) {
            res += " - " + getCost();
        }
        return res;
    }

}















