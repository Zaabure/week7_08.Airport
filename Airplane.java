//letadlo ma ID a kapacitu


public class Airplane {
    private String ID;
    private int capacity;

    //pri vytvoreni letadla vime unikatni ID i kapacitu, nemeni se
    public Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }

    public String getID() {
        return ID;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return getID() + " (" + getCapacity() + ")";
    }
}
