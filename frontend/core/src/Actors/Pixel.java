package Actors;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Pixel extends Actor {

    private Pixmap pixmap;
    private final Vector2 gridPos;
    private final Vector2 canvasPos;
    private final int size;
    private Texture t;
    private String id;

    public Pixel(Vector2 gridPos, Vector2 canvasPos, int size) {
        this.gridPos = gridPos;
        this.canvasPos = canvasPos;
        this.size = size;
        id = gridPos.x + " : " + gridPos.y;
        createPixmap();
        setBounds(canvasPos.x, canvasPos.y, size, size);
        setListener();
    }

    private void setListener() {
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(id);
                pixmap = new Pixmap(size, size, Pixmap.Format.RGBA8888);
                pixmap.setColor(0, 0, 0, 1);
                pixmap.fillRectangle(0, 0, size, size);
                t = new Texture(pixmap);
                pixmap.dispose();
            }
        });
    }

    private void createPixmap() {
        pixmap = new Pixmap(size, size, Pixmap.Format.RGBA8888);
        setColor();
        pixmap.fillRectangle(0, 0, size, size);
        t = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(t, canvasPos.x, canvasPos.y);
    }

    private void setColor() {
        float R = MathUtils.random();
        float G = MathUtils.random();
        float B = MathUtils.random();

        pixmap.setColor(R, G, B, 1);
    }
}
