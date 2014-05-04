package com.esgi.euterpe.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;

import java.io.InputStream;

public class GameScreen implements Screen, InputProcessor{

    private Game game;
    private Sound soundToAnalyse;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {

        Gdx.app.log("Euterpe", "Entrée dans le GameScreen");

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        soundToAnalyse = Gdx.audio.newSound(Gdx.files.internal("sounds/background.mp3"));

        FileHandle mp3soung = Gdx.files.internal("sounds/background.mp3");
        readMp3Table(mp3soung.read());

    }

    private void readMp3Table(InputStream sound)
    {

        Gdx.app.log("Euterpe","Entrée dans la fonction readM3Table");

        /************/

        //AudioInputStream

        //Test JNI

        /*
        AudioDevice playbackDevice = Gdx.audio.newAudioDevice(44100, true);
        AudioRecorder recordingDevice = Gdx.audio.newAudioRecorder(44100, true);
        short[] samples = new short[44100 * 10]; // 10 seconds mono audio
        recordingDevice.read(samples, 0, samples.length);
        playbackDevice.writeSamples(samples, 0, samples.length);
        recordingDevice.dispose();
        playbackDevice.dispose();
        */


        /************/

        Gdx.app.log("Euterpe", "A pu passer l'analyse du tableau de bytes");

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX+ " " + screenY);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
