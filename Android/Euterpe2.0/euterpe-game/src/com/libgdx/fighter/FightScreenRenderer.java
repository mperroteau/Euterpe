package com.libgdx.fighter;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.fighter.model.LF2Actor;
import com.libgdx.fighter.model.LF2Animation;

public class FightScreenRenderer implements IRenderer{
	
//	private float ppuX;
//	private float ppuY;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
//	private Rectangle viewport;
	private AssetManager assetManager;
	private FightScreenController fsController;
//	private ArrayList<Texture> gameObjectTexture;
//	private ArrayList<Integer> gameObjCurrFrame;
//	private ArrayList<TextureRegion[]> gameObjectTextureRegion;

	
	private ArrayList<LF2Animation> lf2Animation;
	
	private ArrayList<LF2Actor> lf2Actors;
	private InputHandler inputHandler;
	
	private float stateTime;
	
	private FightWorld fw;
	private ShapeRenderer debugRenderer = new ShapeRenderer();
	
	private final static int VIRTUAL_WIDTH = Config.VIRTAUL_MAP_WIDTH;
	private final static int VIRTUAL_HEIGHT = Config.VIRTUAL_MAP_HEIGHT;
	private final static float ASPECT_RATIO = VIRTUAL_WIDTH/VIRTUAL_HEIGHT;
	
	public FightScreenRenderer(FightScreenController fsController){
		this.fsController = fsController;
	}
	
	public FightScreenRenderer(FightWorld fw, AssetManager assetMaanger){
		this.fw = fw;
		this.assetManager = assetMaanger;
		this.camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
//		this.camera.position.set(VIRTUAL_WIDTH/2 ,VIRTUAL_HEIGHT/2 , 0);
		this.camera.setToOrtho(false, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		this.camera.update();
		
		this.batch = new SpriteBatch();
//		this.gameObjectTexture = new ArrayList<Texture>();
		
		this.lf2Animation = new ArrayList<LF2Animation>();
		
		initSomeTestingData();
	}

	private void initSomeTestingData(){
		this.fw.initTestingFW();
		
	
//		LF2Animation animation1 = new LF2Animation(this.fw.getGameObjects().get(0), this.assetManager);
//		this.lf2Animation.add(animation1);
		this.inputHandler = new InputHandler(this.fsController, this.assetManager);
		
		
		
		
		
		
	}
	
	@Override
	public void render() {
		stateTime += Gdx.graphics.getDeltaTime();
		initDemo();
//		initImgDemo();
		
		drawActor(stateTime);
	}

	@Override
	public void update(float deltatime) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawActor(float stateTime){
		batch.begin();
		batch.enableBlending();
		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
		drawController(batch);
		
		LF2Actor actor1 = this.fw.getActor(0);
		LF2Actor actor2 = this.fw.getActor(1);
		
		actor1.update(stateTime, 100);
		actor2.update(stateTime, 200);
		
		TextureRegion r = actor1.getCurrentPic();
		TextureRegion r2 = actor2.getCurrentPic();
		batch.draw(r, actor1.getPosition().x, actor1.getPosition().y);
		batch.draw(r2, actor2.getPosition().x * 2, actor2.getPosition().y * 2);
		
		
		
		batch.end();
	}
	
	private void drawController(SpriteBatch batch){
		//Projection camera for inputhandler
		batch.setProjectionMatrix(this.inputHandler.getCamera().combined);
		batch.draw(this.inputHandler.getControllerRegion(), 0, 0);
	}
	
//	private void initImgDemo(){
//		
//		batch.begin();
//		batch.enableBlending();
//		batch.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
//		
//		
//		LF2Animation ani1 = this.lf2Animation.get(0);
//		int currFrameNum = ani1.getCurrFrameNum();
//		int currWait = this.fw.getGameObject(0).getFrame(currFrameNum).wait;
//		int nextFrame = this.fw.getGameObject(0).getFrame(currFrameNum).next;
//		
//		TextureRegion curr = ani1.getKeyFramePic(stateTime, currWait , currFrameNum, nextFrame);
//		
//		//Projection camera for inputhandler
//		batch.setProjectionMatrix(this.inputHandler.getCamera().combined);
//		batch.draw(this.inputHandler.getControllerRegion(), 0, 0);
//		
//		batch.setProjectionMatrix(this.getCamera().combined);
//		
//		batch.draw(curr, 40, 40);
//		batch.end();
//		
//	}
	
	private void initDemo(){
		this.debugRenderer.setProjectionMatrix(camera.combined);
		this.debugRenderer.begin(ShapeType.Line);
		
//		Rectangle player = this.fw.getGameObject(0).getBound();
		this.debugRenderer.setColor(1, 0, 0, 1);
//		this.debugRenderer.rect(40, 40, player.width, player.height);
		
//		this.debugRenderer.rect(300, 80, player.width, player.height);
		
		Rectangle g1 = this.fw.getMapLayer(0);
		Rectangle g2 = this.fw.getMapLayer(1);
		Rectangle g3 = this.fw.getMapLayer(2);
		Rectangle g4 = this.fw.getMapLayer(3);
		this.debugRenderer.setColor(0,1,0,1);
		
		this.debugRenderer.rect(g1.x, g1.y, g1.width, g1.height);
		this.debugRenderer.rect(g2.x, g2.y, g2.width, g2.height);
		this.debugRenderer.setColor(0,1,1,1);
		this.debugRenderer.rect(g3.x, g3.y, g3.width, g3.height);
		this.debugRenderer.rect(g4.x, g4.y, g4.width, g4.height);
		
		
		
		
		this.debugRenderer.setProjectionMatrix(this.inputHandler.getCamera().combined);
		this.debugRenderer.setColor(1, 0, 0, 1);
		Rectangle[] btns = this.inputHandler.getButtons();
		this.debugRenderer.rect(btns[InputHandler.KEY_UP].x, btns[InputHandler.KEY_UP].y, btns[InputHandler.KEY_UP].width, btns[InputHandler.KEY_UP].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_DOWN].x, btns[InputHandler.KEY_DOWN].y, btns[InputHandler.KEY_DOWN].width, btns[InputHandler.KEY_DOWN].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_LEFT].x, btns[InputHandler.KEY_LEFT].y, btns[InputHandler.KEY_LEFT].width, btns[InputHandler.KEY_LEFT].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_RIGHT].x, btns[InputHandler.KEY_RIGHT].y, btns[InputHandler.KEY_RIGHT].width, btns[InputHandler.KEY_RIGHT].height);
		
		this.debugRenderer.rect(btns[InputHandler.KEY_A].x, btns[InputHandler.KEY_A].y, btns[InputHandler.KEY_A].width, btns[InputHandler.KEY_A].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_J].x, btns[InputHandler.KEY_J].y, btns[InputHandler.KEY_J].width, btns[InputHandler.KEY_J].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_D].x, btns[InputHandler.KEY_D].y, btns[InputHandler.KEY_D].width, btns[InputHandler.KEY_D].height);
		
		this.debugRenderer.rect(btns[InputHandler.KEY_F8].x, btns[InputHandler.KEY_F8].y, btns[InputHandler.KEY_F8].width, btns[InputHandler.KEY_F8].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_F9].x, btns[InputHandler.KEY_F9].y, btns[InputHandler.KEY_F9].width, btns[InputHandler.KEY_F9].height);
		this.debugRenderer.rect(btns[InputHandler.KEY_PAUSE].x, btns[InputHandler.KEY_PAUSE].y, btns[InputHandler.KEY_PAUSE].width, btns[InputHandler.KEY_PAUSE].height);
		
		
		this.debugRenderer.end();
	}
	
	public void resize(int width, int height){
		float aspectRatio = width/height;
		
		float scale = 1.0F;
		Vector2 crop = new Vector2(0.0F, 0.0F);
		if (aspectRatio > ASPECT_RATIO)
		{
			scale = height / VIRTUAL_HEIGHT;
			crop.x = ((width - VIRTUAL_WIDTH * scale) / 2.0F);
		}
		else if (aspectRatio < ASPECT_RATIO)
		{
			scale = width / VIRTUAL_WIDTH;
			crop.y = ((height - VIRTUAL_HEIGHT * scale) / 2.0F);
		}
		else
		{
			scale = width / VIRTUAL_WIDTH;
		}
		float w = VIRTUAL_WIDTH * scale;
		float h = VIRTUAL_HEIGHT * scale;
		
//		this.viewport = new Rectangle(crop.x, crop.y, w, h);
	}
	
	 public OrthographicCamera getCamera(){
		 return this.camera;
	 }
}
