public class Airplane {
    private String ID;
    private int capacity;

     Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }

    public String getID() {
        return ID;
    }

    private int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return getID() + " (" + getCapacity() + " ppl)";
    }
}
