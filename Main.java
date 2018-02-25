import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String input = "1\n" + "HA-LOL\n" + "42\n" + "1\n" + "G-OWAC\n" + "101\n" + "2\n" + "HA-LOL\n"
                + "HEL\n" + "BAL\n" + "2\n" + "G-OWAC\n" + "JFK\n" + "BAL\n" + "2\n" + "HA-LOL\n" + "BAL\n" +
                "HEL\n" + "x\n" + "1\n" + "2\n" + "3\n";

        input = "1\n" +
                "AY-123\n" +
                "108\n" +
                "1\n" +
                "DE-213\n" +
                "75\n" +
                "1\n" +
                "RU-999\n" +
                "430\n" +
                "2\n" +
                "AY-123\n" +
                "HEL\n" +
                "TXL\n" +
                "2\n" +
                "AY-123\n" +
                "JFK\n" +
                "HEL\n" +
                "2\n" +
                "DE-213\n" +
                "TXL\n" +
                "BAL\n" +
                "x\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "AY-123\n" +
                "x\n";

        Scanner reader = new Scanner(System.in);
           Airport airport = new Airport();

        airport.startUI(reader);

    }
}
