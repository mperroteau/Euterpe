package com.libgdx.fighter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class InputHandler implements GestureListener, InputProcessor {

	private OrthographicCamera camera;
	private Vector3 pos;
	private Texture controllerTexture;
	private TextureRegion controllerRegion;
	
	private Rectangle[] buttons;
	
	public final static int KEY_UP = 0;
	public final static int KEY_DOWN = 1;
	public final static int KEY_LEFT = 2;
	public final static int KEY_RIGHT = 3;
	
	public final static int KEY_A = 4;
	public final static int KEY_J = 5;
	public final static int KEY_D = 6;
	
	public final static int KEY_PAUSE = 7;
	public final static int KEY_F8 = 8;
	public final static int KEY_F9 = 9;
	
	public final static int KEY_NE = 10;
	public final static int KEY_SE = 11;
	public final static int KEY_SW = 12;
	public final static int KEY_NW = 13;	
	
	
	public InputHandler(FightScreenController fsController, AssetManager assetManager){
		this.controllerTexture = assetManager.get("data/controller.png",Texture.class);
		this.controllerRegion = new TextureRegion(this.controllerTexture, 0, 0, Config.VIRTAUL_MAP_WIDTH, Config.VIRTUAL_MAP_HEIGHT);
		
		this.buttons = new Rectangle[14];
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Config.VIRTAUL_MAP_WIDTH, Config.VIRTUAL_MAP_HEIGHT);
		this.pos = new Vector3();
//		this.camera.unproject(pos);
		initButtonBound();
	}
	
	private void initButtonBound(){
		this.buttons[KEY_UP] = new Rectangle(58, 123, 54, 54);
		this.buttons[KEY_DOWN] = new Rectangle(58, 15, 54, 54);
		this.buttons[KEY_LEFT] = new Rectangle(4, 69, 54, 54);
		this.buttons[KEY_RIGHT] = new Rectangle(112, 69, 54, 54);
		
		this.buttons[KEY_A] = new Rectangle(634, 138, 63, 63);
		this.buttons[KEY_J] = new Rectangle(698, 70, 63, 63);
		this.buttons[KEY_D] = new Rectangle(634, 8, 63, 63);
		
		this.buttons[KEY_F9] = new Rectangle(647, 421, 63, 37);
		this.buttons[KEY_F8] = new Rectangle(569, 421, 63, 37);
		this.buttons[KEY_PAUSE] = new Rectangle(719, 421, 48, 48);
		
		this.buttons[KEY_NE] = new Rectangle(112, 123, 54, 54);
		this.buttons[KEY_SE] = new Rectangle(112, 15, 54, 54);
		this.buttons[KEY_SW] = new Rectangle(4, 15, 54, 54);
		this.buttons[KEY_NW] = new Rectangle(4, 123, 54, 54);
	}
	
	public TextureRegion getControllerRegion(){
		return this.controllerRegion;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		System.out.println(character);
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		
		if(isButtonPressed(x, y, KEY_UP)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: " + " Button : " + button);
			Gdx.app.log("Button", "UP");
		}
		
		return true;
	}
	
	private boolean isButtonPressed(float touchX, float touchY, int btnName){
		this.pos.x = touchX;
		this.pos.y = touchY;
		
		this.camera.unproject(pos);
		
		
		float camX = pos.x;
		float camY = pos.y;
		
		float btnX = this.buttons[btnName].x;
		float btnY = this.buttons[btnName].y;
		
		float btnXBound = btnX + this.buttons[btnName].width;
		float btnYBound = btnY + this.buttons[btnName].height;
		
		
		return ((camX >= btnX && camX <= btnXBound) && (camY >= btnY && camY <= btnYBound));
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(isButtonPressed(x, y, KEY_UP)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: " + count + " Button : " + button);
			Gdx.app.log("Button", "UP");
		}
		
		
		if(isButtonPressed(x, y, KEY_DOWN)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "DOWN");
		}

		
		if(isButtonPressed(x, y, KEY_LEFT)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "LEFT");
		}
		
		
		if(isButtonPressed(x, y, KEY_RIGHT)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "RIGHT");
		}
		
		
		
		if(isButtonPressed(x, y, KEY_A)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "A");
		}
		
		
		if(isButtonPressed(x, y, KEY_J)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "J");
		}
		
		
		if(isButtonPressed(x, y, KEY_D)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "D");
		}
	
		if(isButtonPressed(x, y, KEY_NE)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "NE");
		}
		
		if(isButtonPressed(x, y, KEY_SE)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "SE");
		}
		
		if(isButtonPressed(x, y, KEY_SW)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "SW");
		}
		
		if(isButtonPressed(x, y, KEY_NW)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "NW");
		}
		
		if(isButtonPressed(x, y, KEY_F8)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "F8");
		}
		
		if(isButtonPressed(x, y, KEY_F9)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "F9");
		}
		
		
		if(isButtonPressed(x, y, KEY_PAUSE)){
			Gdx.app.log("Camera", "X: " + pos.x + " Y: " + (pos.y) +  " Count: "  + count +  " Button : " + button);
			Gdx.app.log("Button", "PAUSE");
		}
		
		
		
		
		return true;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Rectangle[] getButtons(){
		return this.buttons;
	}

	
	public void setCamera(OrthographicCamera camera){
		this.camera = camera;
	}
	
	public OrthographicCamera getCamera(){
		return this.camera;
	}

}
