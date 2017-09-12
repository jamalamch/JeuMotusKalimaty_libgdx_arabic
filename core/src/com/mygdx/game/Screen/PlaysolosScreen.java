package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.BaseDonnees.BaseDonnes;
import com.mygdx.game.BaseDonnees.Mot;
import com.mygdx.game.Windowgame.Dialog_game;
import com.mygdx.game.buttons.buttondeclavier;
import com.mygdx.game.layer.gameonplayer;

import java.io.IOException;
import java.util.Vector;

import static com.mygdx.game.MyGdxGame.x;
import static com.mygdx.game.MyGdxGame.y;


/**
 * Created by HP on 10/03/2019.
 */

public class PlaysolosScreen extends BaseScreenAdapter{
    public static Vector<Mot> tabmot ;
    private gameonplayer game;
    public static Dialog_game dialogexit;

    public PlaysolosScreen(){
        super();
        this.mStage = new Stage();
        Image back1 = new Image(Assets.background);
        back1.setSize(x, y);
        back1.setPosition(x/2, y/2, Align.center);
        mStage.addActor(back1);
        tabmot= new Vector<Mot>();
        dialogexit = new Dialog_game(" هل ترغب في الخروج ");
        dialogexit.setScale(MyGdxGame.RATA);
        dialogexit.setSize(500, 130);
        dialogexit.setPosition((x-500*MyGdxGame.RATA)/2, (y-130*MyGdxGame.RATA)/2);
        dialogexit.accepter.addListener(new ClickListener(){
            public void clicked (InputEvent event, float x, float y) {
                dialogexit.setVisible(false);
                game.getresulta().setVisible(false);
                setnovelScreen();
            }});
        try {
            com.mygdx.game.BaseDonnees.BaseDonnes.connectToDB();
            com.mygdx.game.BaseDonnees.BaseDonnes.selectFromDB(MyGdxGame.getlongmot(),tabmot);
        } catch (IOException e) {
            e.printStackTrace();
        }

        game=new gameonplayer();
        buttondeclavier.game=game;
        this.mStage.addActor(game);
        this.mStage.addActor(game.getresulta());
        this.mStage.addActor(dialogexit);
   
    }
    @Override
    public void show(){
    	try {
			BaseDonnes.connectToDB();
		} catch (IOException e) {
			e.printStackTrace();
		}
        game.affichage();
        Gdx.input.setInputProcessor(mStage);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0.24f,0.24f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mStage.draw();
        mStage.act();
        if( Gdx.input.isKeyJustPressed(Input.Keys.BACK)||Gdx.input.isKeyJustPressed(Input.Keys.ENTER) ){
               dialogexit.Open();
        }
    }
    public void setnovelScreen(){
        game.task.cancel();
        BaseDonnes.diconnect();
        MyGdxGame.lanchmainscreen();
    }

    @Override
    public void resize(int width, int height) {
        if(width != MyGdxGame.x || height != MyGdxGame.y)
        Gdx.graphics.setWindowedMode(MyGdxGame.x,MyGdxGame.y);
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
        super.dispose();
    }
}




