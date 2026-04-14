package presentation;

public enum MessageType {
    WIN("\u001B[34m", "🏆"),      //синий
    INFO("\u001B[0m", "🔔"), // белый/стандартный
    LOSE("\u001B[31m", "😢"),
    HINT("\u001B[32m", "💡"),     // зеленый,
    ERROR("\u001B[31m", "🚫");

    private final String colorCode;
    private final String icon;

    MessageType(String colorCode, String icon) {
        this.colorCode = colorCode;
        this.icon = icon;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getIcon() {
        return icon;
    }
}
