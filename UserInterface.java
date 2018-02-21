import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private Flight flight;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        flight = new Flight()
    }

    public void airportUI() {
        begin();
    }

    private void begin() {
        while (true) {
            System.out.println("Choose operation:\n" +
                    "[1] Add airplane\n" +
                    "[2] Add flight\n" +
                    "[x] Exit");
            String input = reader.nextLine();
            if (input.equals("x"))
                break;
            else if (input.equals("1"))
                addAirplane();

            else if (input.equals("2"))
                addFlight();
        }
    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String planeName = reader.nextLine();
        System.out.println();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(reader.nextLine());
        flight.addPlaneToList(new Airplane(planeName, planeCapacity));
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String planeName = reader.nextLine();
        System.out.println();

        System.out.print("Give departure airport code: ");
        String odkud = reader.nextLine();
        System.out.println();

        System.out.print("Give destination airport code: ");
        String kam = reader.nextLine();

        flight.addFlightToMap(odkud, kam);
    }

    private void printPlanes() {

    }

    private void printFlights() {

    }

    private void printPlaneInfo() {

    }

    private void quit() {

    }
}
