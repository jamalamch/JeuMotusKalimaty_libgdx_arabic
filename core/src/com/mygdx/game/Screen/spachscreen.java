package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;

public class spachscreen  extends BaseScreenAdapter {
	private int j=1;
    private int x ;
	private int y;

	boolean toched = false;
	boolean enter = true;
	public spachscreen(){
		super();
		x= MyGdxGame.x;
		y= MyGdxGame.y;
		mStage = new Stage();
		Assets.load();
		if(MyGdxGame.isMusic())Assets.musicspash.play();
		MyGdxGame.loadScrennmain();
	}
	@Override
	public void show() {
		Image back1 = new Image(Assets.background);
		Image back2 = new Image(Assets.background);
		Image image = new Image(Assets.logo);
		back1.setSize(x, y);
		back2.setSize(x, y);
		back1.setPosition(x/2, y/2,Align.center);
		back2.setPosition(x/2+x, y/2,Align.center);
		image.setSize(y/3, y/3);
		image.setPosition(x/2, y/2,Align.center);
		image.addAction(Actions.sequence(Actions.rotateBy(20,2),Actions.rotateBy(-20,3)));
		back1.addAction(Actions.moveBy(-x,0,6));
		back2.addAction(Actions.moveBy(-x,0,6));
		mStage.addActor(back1);
		mStage.addActor(back2);
		mStage.addActor(image);
		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
               toched=true;
			}
		},5);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0.24f,0.24f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isTouched() || toched) {
			j++;
			toched = true;
		if(mStage.getActors().items[2].getHeight()<Gdx.graphics.getHeight() && mStage.getActors().items[2].getWidth()<Gdx.graphics.getWidth()){
			mStage.getActors().items[2].setSize(mStage.getActors().items[2].getWidth()+j, mStage.getActors().items[2].getHeight()+j);
			mStage.getActors().items[2].setPosition(x/2, y/2,Align.center);
		}else if(enter){
			setmainScreen();
		}
		}
			mStage.draw();
		    mStage.act();
	}


    public void setmainScreen(){
		MyGdxGame.lanchmainscreen();
		   enter = false;
		MyGdxGame.loadScrenplay();

	}
	@Override
	public void resize(int width, int height){
        super.resize(width,height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
        super.dispose();
	}

}
