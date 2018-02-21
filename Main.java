import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        String input = "";
        Scanner reader = new Scanner(input);
        Flight airTraffic = new Flight();


        UserInterface ui = new UserInterface(reader,airTraffic);

        ui.airportUI();
    }
}
