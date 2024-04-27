package Lab2;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public Cart(){
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOdered[this.qtyOrdered] = disc;
            this.qtyOrdered += 1;
            System.out.println("The disc has been added ");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (int i = 0; i <dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOdered[qtyOrdered] = dvdList[i];
                qtyOrdered += 1;
                System.out.println("The disc has been added ");
            }
            else {
                System.out.println("The cart is almost full");
                break
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOdered[qtyOrdered] = dvd1;
            qtyOrdered += 1;
            System.out.println("The disc "+'"'+ dvd1.getTitle()+'"'+"has been added ");
        }
        else{
            System.out.println("The cart is almost full");
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOdered[qtyOrdered] = dvd2;
            qtyOrdered += 1;
            System.out.println("The disc"+'"'+dvd2.getTitle()+'"'+"has been added")
        }
        else{
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < this.qtyOrdered; i+= 1){
            if(this.itemsOdered[i].equals(disc)){
                for(int j = i; j < this.qtyOrdered; j += 1){
                    this.itemsOdered[j] = this.itemsOdered[j + 1];
                }
                this.itemsOdered[this.qtyOrdered-1] = null;
                this .qtyOrdered -= 1;
                System.out.println("The disc has been removed");
                break;
            }
        }
    }

    public float totalCost(){
        float res=0;
        for(int i = 0; i < qtyOrdered; i += 1)
        {
            res += itemsOdered[i].getCost();
        }
        return res;                            
    }


}
