package Screens;

import Stage.GameStage;
import Utils.Helper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class GameScreen implements Screen {

    private GameStage gameStage;

    public GameScreen() {
        this.gameStage = new GameStage(new ScreenViewport());
        Helper.getSocket().connect();
    }

    @Override
    public void show() {
        // Sets the input processor to the stage so that it can handle the inputs of the user
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        gameStage.draw();
        gameStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
