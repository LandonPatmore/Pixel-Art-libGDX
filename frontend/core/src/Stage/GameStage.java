package Stage;

import Actors.Pixel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameStage extends Stage {

    private Pixel[][] pixels = new Pixel[50][50];
    private final int pixelSize = 10;

    public GameStage(Viewport viewport) {
        super(viewport);
        generatePixels();
    }

    private void generatePixels() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel(new Vector2(i, j), new Vector2(i * pixelSize, j * pixelSize), pixelSize);
                addActor(pixels[i][j]);
            }
        }
    }
}
