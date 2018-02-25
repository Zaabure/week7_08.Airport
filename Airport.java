import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Airport {

    private Map<String, Airplane> listOfPlanes = new HashMap<String, Airplane>();
    private Map<String, Flight> listOfFlights = new HashMap<String, Flight>();
    private Scanner reader;


    public Airport(Scanner reader) {
        this.reader = reader;
    }


    public void startUI() {
        startAirportPanel();
        startFlightService();
    }

    private void startAirportPanel() {
        System.out.println("Airport panel\n" +
                "--------------------");
        String input;
        do {
            showAirportPanelMenu();
            input = getUserInput(reader);

            if (input.equals("1"))
                addPlane();
            else if (input.equals("2"))
                addFlight();
            else if (!input.equals("x"))
                System.out.println("Bad input");
        }
        while (!input.equals("x"));
    }

    private void startFlightService() {
        System.out.println("Flight service\n" +
                "------------\n" +
                "\n");
        String input;
        do {
            showFlightServiceMenu();
            input = getUserInput(reader);

            if (input.equals("1"))
                printAllPlanes();
            else if (input.equals("2"))
                printAllFlights();
            else if (input.equals("3"))
                printPlaneInfo();
            else if (!input.equals("x"))
                System.out.println("Bad input");
        }
        while (!input.equals("x"));
    }

    private void addPlane() {
        System.out.println("Give plane ID: ");
        String planeID = getUserInput(reader);

        System.out.println("Give plane Capacity:");
        int capacity = getNumericInput(reader);

        Airplane newAirplane = new Airplane(planeID, capacity);
        listOfPlanes.put(planeID, newAirplane);
    }

    private void addFlight() {

        Airplane selectedAirplane = getExistingPlane();

        System.out.println("Give departure airport code:");
        String source = getUserInput(reader);

        System.out.println("Give destination airport code:");
        String destination = getUserInput(reader);

        Flight newFlight = new Flight(selectedAirplane, source, destination);

        listOfFlights.put(selectedAirplane.getID() + source + destination, newFlight);
    }

    private void printAllPlanes() {
        for (Airplane plane : listOfPlanes.values())
            System.out.println(plane.toString());
    }

    private void printAllFlights() {
        for (Flight flight : listOfFlights.values()) {
            System.out.println(flight.toString());
        }
    }

    private void printPlaneInfo() {
        for (Airplane printedPlane : listOfPlanes.values()) {
            if (printedPlane.getID().equals(getExistingPlane().getID())) {
                System.out.println(printedPlane.toString());
                break;
            }
        }
    }

    //get Airplane object from getAirplaneID,
    //if Airplane object is null, call getAirplaneID again
    //at last, return plane (must not be null)
    private Airplane getExistingPlane() {
        Airplane searchedPlane = getAirplaneFromID();

        while (searchedPlane == null) {
            System.out.println("This plane was not found");
            searchedPlane = getAirplaneFromID();
        }
        return searchedPlane;
    }

    //ask user for ID, return Airplane with that ID, else return null
    private Airplane getAirplaneFromID() {
        System.out.println("Give plane ID:");
        String planeID = getUserInput(reader);

        Airplane searchedPlane = null;
        for (String index : listOfPlanes.keySet()) {
            if (index.equals(planeID)) {
                searchedPlane = listOfPlanes.get(index);
                break;
            }
        }
        return searchedPlane;
    }

    private static int getNumericInput(Scanner reader) {
        return Integer.parseInt(reader.nextLine());
    }

    private static String getUserInput(Scanner reader) {
        return reader.nextLine();
    }

    private static void showAirportPanelMenu() {
        System.out.println("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit\n");
        System.out.print("> ");
    }

    private void showFlightServiceMenu() {
        System.out.println("Choose action:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit\n");
        System.out.print("> ");
    }

}