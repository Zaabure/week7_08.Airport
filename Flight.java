

public class Flight {


    private Airplane airplane;

    //vytvoreni letu
    private Flight flight;
    private String source;
    private String destination;


    //nutno specifikovat pro ktere letadlo let vytvarim
     Flight(Airplane airplane, String source, String destination) {
        this.airplane = airplane;
        this.source = source;
        this.destination = destination;

    }

    @Override
    public String toString() {
        return airplane.toString() + " (" + source + "-" + destination + ")";

    }
}
