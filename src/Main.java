import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        GameMap map = new GameMap( 5,10); // init of the game board and setting the location to (0,0)/(h/w)
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello this is your life now?!");
        System.out.println("H - help");
        map.showMap();

        while (true){

            System.out.println();
            System.out.print("input: ");
            String input = rd.readLine();
            System.out.println();

            switch (input.toLowerCase()) {
                // --- misc controls ---
                case "h" -> helpMenu();
                case "q" -> quit();
                case "m" -> {
                    System.out.println("--- showing the map ---");
                    map.showMapWithInfo();
                }

                // --- movement controls ---
                case "w" -> {
                    map.moveup();
                    map.showMap();
                }
                case "a" -> {
                    map.moveleft();
                    map.showMap();
                }
                case "s" -> {
                    map.movedown();
                    map.showMap();
                }
                case "d" -> {
                    map.moveright();
                    map.showMap();
                }
                case "clear" -> { /* TODO: does not work, implement to clear a console seems to not work at all in IDE's terminal and in windows CMD: SAAAAAD*/
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                case "r" -> {
                    map.generate();
                }
                default -> {
                    System.out.println("unknown input");
                    System.out.println("press 'H' for help with the controls");
                    System.out.println();
                    map.showMap();
                }
            }
        }
    }

    private static void helpMenu(){
        System.out.println("!!! THIS IS THE HELP MENU !!!");
        System.out.println();
        System.out.println("--- MOVEMENT ---");
        System.out.println("W - up");
        System.out.println("A - left");
        System.out.println("D - right");
        System.out.println("S - down");
        System.out.println("--- SYSTEM ---");
        System.out.println("M - map");
        System.out.println("R - randomly generate ending locations");
        System.out.println("H - help");
        System.out.println("Q - quit");

    }

    private static void quit(){
        System.out.println("Thank you! Quiting life");
        System.exit(1);
    }
}