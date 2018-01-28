package Utils;

import com.badlogic.gdx.graphics.Color;

public class Helper {
    private static Color selectedColor = Color.BLACK;

    public static void setSelectedColor(Color color) {
        Helper.selectedColor = color;
    }

    public static Color getSelectedColor() {
        return Helper.selectedColor;
    }
}
