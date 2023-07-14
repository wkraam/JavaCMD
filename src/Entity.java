public class Entity {
    private int type;
    private int w_location;
    private int h_location;
    private String symbol;
    private int color;

    public static final String redText = "\u001B[31m";
    public static final String greenText = "\u001B[32m";
    public static final String blueText = "\u001B[34m";
    public static final String resetTextColor = "\u001B[0m";

    public Entity(int type, String symbol, int color, int w_location, int h_location) {
        this.type = type;
        this.symbol = symbol;
        this.color = color;
        this.w_location = w_location;
        this.h_location = h_location;
    }

    public int[] getLocation() {
        return new int[]{this.h_location, this.w_location};
    }

    public void setLocation(int height, int width) {
        this.h_location = height;
        this.w_location = width;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int newType){
        this.type = newType;
    }

    public String getSymbol() {
        String color2;
        switch (color){
            case 0 -> { color2 = redText; }
            case 1 -> { color2 = greenText; }
            case 2 -> { color2 = blueText; }
            default -> { color2 = resetTextColor; }
        }
        return color2 + "" + symbol + "" + resetTextColor;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getColor() {
        return "Color is: "+color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
