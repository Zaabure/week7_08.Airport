
import java.util.HashMap;

public class Flight {


    private Airplane airplane;

    //vytvoreni letu
    private Flight flight;


    // trasa letadla Z a DO letiste, vytvarena pro kazde letadlo unikatne
    private HashMap<String, String> route;

    //nutno specifikovat pro ktere letadlo let vytvarim
    public Flight(Airplane airplane) {
        this.airplane = airplane;
        this.route = new HashMap<String, String>() {

        };
    }

    public void addFlightToMap(String odkud, String kam) {
        route.put(odkud, kam);
    }

}
