import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Airport {

    private Map<String, Airplane> listOfPlanes = new HashMap<String, Airplane>();
    private Map<String, Flight> listOfFlights = new HashMap<String, Flight>();


    public void startUI(Scanner reader) {
        startAirportPanel(reader);
        startFlightService(reader);
    }

    private void startAirportPanel(Scanner reader) {
        System.out.println("Airport panel");
        System.out.println("----------------");
        System.out.println();


        String input;
        do {
            showAirportPanelMenu();
            input = getUserInput(reader);

            if (input.equals("1"))
                addPlane(reader);
            else if (input.equals("2"))
                addFlight(reader);
            else if (!input.equals("x"))
                System.out.println("Bad input");
        }
        while (!input.equals("x"));
    }

    private void startFlightService(Scanner reader) {
        System.out.println("Flight service");
        System.out.println("----------------");
        System.out.println();

        String input;
        do {
            showFlightServiceMenu();
            input = getUserInput(reader);

            if (input.equals("1"))
                printAllPlanes();
            else if (input.equals("2"))
                printAllFlights();
            else if (input.equals("3"))
                printPlaneInfo(reader);
            else if (!input.equals("x"))
                System.out.println("Bad input");
        }
        while (!input.equals("x"));
    }

    private void addPlane(Scanner reader) {
        System.out.print("Give plane ID: ");
        String planeID = getUserInput(reader);

        System.out.print("Give plane capacity: ");
        int capacity = getNumericInput(reader);

        Airplane newAirplane = new Airplane(planeID, capacity);
        listOfPlanes.put(planeID, newAirplane);
    }

    private void addFlight(Scanner reader) {

        Airplane selectedAirplane = getAirplaneFromID(reader);

        System.out.print("Give departure airport code: ");
        String source = getUserInput(reader);

        System.out.print("Give destination airport code: ");
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

    private void printPlaneInfo(Scanner reader) {
        System.out.println(getAirplaneFromID(reader).toString());
    }

    private Airplane getAirplaneFromID(Scanner reader) {
        Airplane searchedPlane;
        do {
            System.out.print("Give plane ID: ");
            String planeID = getUserInput(reader);
            searchedPlane = listOfPlanes.get(planeID);
            if (searchedPlane == null)
                System.out.println("Plane with ID " + planeID + " does not exist");
        }
        while (searchedPlane == null);
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
                "[x] Exit");
        System.out.print("> ");
    }

    private void showFlightServiceMenu() {
        System.out.println("Choose action:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit");
        System.out.print("> ");
    }

}