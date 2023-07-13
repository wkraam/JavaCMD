import java.util.concurrent.ThreadLocalRandom;

public class GameMap {
    private int height;
    // the height of the game board.
    private int width;
    // the width of the game board.
    private int[] location;
    // first element is the height location, second is the width location.

    public GameMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.location = new int[]{0, 0};
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    // symbols for map ‾ - _ | └ ┐┌ ┘├ ┤┬ ┴ ┼

    public static final String redText = "\u001B[31m";
    public static final String greenText = "\u001B[32m";
    public static final String xText = "\u001B[30m";
    public static final String resetTextColor = "\u001B[0m";

    private String floorText = greenText + "0" + resetTextColor;
    private String playerText = redText +"X" + resetTextColor;
    public void showMap() {
        for (int i = 0; i < getHeight(); i++) {
            System.out.print("|");
            for (int j = 0; j < getWidth(); j++) {
                if (i == getLocation()[0]) {
                    if (j == getLocation()[1]) {
                        System.out.print(playerText);
                    }
                    else System.out.print(floorText);
                }
                else System.out.print(floorText);
            }
            System.out.println("|");
        }
    }

    public void showMapWithInfo() {
        System.out.println("height: " + getHeight());
        System.out.println("width: " + getWidth());
        System.out.println("location: " + getLocation()[0] + ", " + getLocation()[1] + " [height , width]");
        showMap();
    }

    public void moveup() {
        if(getLocation()[0]-1 < 0) System.out.println(redText + "this move up is invalid! " + resetTextColor);
        else location[0]--;
    }

    public void moveleft() {
        if(getLocation()[1]-1 < 0) System.out.println(redText +"this move left is invalid! "+ resetTextColor);
        else location[1]--;
    }

    public void movedown() {
        if(getLocation()[0]+2 > getHeight()) System.out.println(redText +"this move down is invalid! "+ resetTextColor);
        else location[0]++;
    }

    public void moveright() {
        if(getLocation()[1]+2 > getWidth()) System.out.println(redText +"this move right is invalid! "+ resetTextColor);
        else location[1]++;
    }
    private int h_end; // height of the ending square
    private int w_end; // width of the ending square
    public void generate() {
        h_end = ThreadLocalRandom.current().nextInt(0, getHeight() + 1);
        w_end = ThreadLocalRandom.current().nextInt(0, getWidth() + 1);

        System.out.println("h: "+h_end+"| w: "+w_end);
    }
}
