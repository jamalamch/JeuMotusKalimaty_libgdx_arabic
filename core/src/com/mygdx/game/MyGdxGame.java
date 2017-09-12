package com.mygdx.game;

import static com.mygdx.game.Screen.PlaysolosScreen.tabmot;

import java.io.IOException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.Screen.BaseScreenAdapter;
import com.mygdx.game.Screen.PlaysolosScreen;
import com.mygdx.game.Screen.mainScreen;
import com.mygdx.game.Screen.spachscreen;



public class MyGdxGame extends Game {

	public static int x ;
	public static int y;
	public static float RATA;
	public static Assets assets= new Assets();


	private static int Score=0;
	private static int longmot=4;
	private static int niveau=1;
	private static int nombermot=5;
	private static int nombertent=6;
	private static int temptotals=100;
	private static int difficulte = 0;
	private static  boolean music = true;
	private static Preferences prefs ;

	private float SCREEN_SWITCH_DURATION = 0.6f;


	private static mainScreen mainscreen;
	private static PlaysolosScreen playsolosscreen;
	private static spachscreen spachscreen;
	@Override
	public void create (){
		x = Gdx.graphics.getWidth();
		y= Gdx.graphics.getHeight();
		RATA=  (float)x/640;
		prefs = Gdx.app.getPreferences("settings.prefs");
        load();
        Assets.loadpro();
	    setScreen( spachscreen = new spachscreen());
	}	  
	public static int getScore() {
		return Score;
	}
	public static void setScore(int y) {
		Score=Score+y;
		prefs.putInteger("Score", Score);
        prefs.flush();
	}
	public static int getlongmot(){
		return longmot;
	}
	public static void setlongmot(int y){
		if(longmot != y)
			try {
				longmot=y;
				com.mygdx.game.BaseDonnees.BaseDonnes.connectToDB();
				com.mygdx.game.BaseDonnees.BaseDonnes.selectFromDB(MyGdxGame.getlongmot(),tabmot);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static int getniveau(){
		return niveau;
	}
	public static void setniveau(int y){
		longmot=y;
	}

	public static void setMusic(boolean music) {
		MyGdxGame.music = music;
		prefs.putBoolean("music",music);
		prefs.flush();
	}

	public static boolean isMusic() {
		return music;
	}

	public static int getNombertent() {
		return nombertent;
	}
	public static void setNombertent(int N) {
		nombertent = N;
	}
	public static int getTemptotals() {
		return temptotals;
	}
	public static void setTemptotals(int T) {
		temptotals = T;
	}
	public static void setNombermot(int nombermot) {
		MyGdxGame.nombermot = nombermot;
	}
	public static int getNombermot() {
		return nombermot;
	}
	public static void setDifficulte(int difficulte) {
		MyGdxGame.difficulte = difficulte;
		setTemptotals(difficulte* 10 + 80);
	}
	public static int getDifficulte() {
		return difficulte;
	}

	public static void load(){
		if(prefs.contains("Score"))      {  Score=prefs.getInteger("Score");   }
		if(prefs.contains("Longmot"))    { longmot=prefs.getInteger("Longmot");  }
		if(prefs.contains("Niveau"))     {  niveau=prefs.getInteger("Niveau");  }
		if(prefs.contains("difficulte")) {  difficulte=prefs.getInteger("difficulte"); }
		if(prefs.contains("Nombertent")) {  temptotals=prefs.getInteger("Temptotals"); }
		if(prefs.contains("Nombermot"))  {  nombermot=prefs.getInteger("Nombermot"); }
		if(prefs.contains("music"))      { 		nombertent=prefs.getInteger("Nombertent"); }
		if(prefs.contains("Temptotals")) { music=prefs.getBoolean("music");  }
		else
		{
			prefs.putBoolean("music",music);
			prefs.putInteger("Score", Score);
			update();
		}
	}
	public static void update(){
		prefs.putInteger("Longmot", longmot);
		prefs.putInteger("Niveau", niveau);
		prefs.putInteger("difficulte", difficulte);
		prefs.putInteger("Nombertent", nombertent);
		prefs.putInteger("Temptotals", temptotals);
		prefs.putInteger("Nombermot", nombermot);
		prefs.flush();
	}
	
	

    @Override
    public void dispose() {
        mainscreen.dispose();
		if(playsolosscreen != null) playsolosscreen.dispose();
		spachscreen.dispose();
    }

	@Override
	public void setScreen(final Screen screen) {
		if (getScreen() == null)
		{
			Gdx.app.log("set novel screen ", " SCREEN" );
			createScreenInAction(screen);
			return;
		}
		else createScreenOutAction(getScreen(), new Runnable() {
			@Override
			public void run() {
				Gdx.app.log("set novel screen ", " SCREEN suivet" );
				createScreenInAction(screen);
			}
		});
	}
	private void createScreenOutAction(final Screen screen , Runnable runnable) {
		Actor actor = ((BaseScreenAdapter) screen).getStage().getRoot();
		actor.setOrigin(x,y);
		actor.getColor().a = 1;
		SequenceAction sequenceAction = new SequenceAction();
		sequenceAction.addAction(Actions.parallel(Actions.alpha(0.3f,SCREEN_SWITCH_DURATION) , Actions.scaleTo(1.5f,1.5f , SCREEN_SWITCH_DURATION, Interpolation.exp5)));
		sequenceAction.addAction(Actions.run(runnable));
		actor.addAction(sequenceAction);
	}
	private void createScreenInAction(final Screen screen) {
		MyGdxGame.super.setScreen(screen);
		Actor actor = ((BaseScreenAdapter) screen).getStage().getRoot();
		actor.setOrigin(x,y);
		actor.getColor().a = 0.3f;
		SequenceAction sequenceAction = new SequenceAction();
		sequenceAction.addAction(Actions.scaleTo(1.5f,1.5f , 0));
		sequenceAction.addAction(Actions.parallel(Actions.alpha(1,SCREEN_SWITCH_DURATION) , Actions.scaleTo(1.0f,1.0f , SCREEN_SWITCH_DURATION , Interpolation.exp5)));
		actor.addAction(sequenceAction);
	}

	public static void loadScrennmain() {
				mainscreen = new mainScreen();
	}
	public static void loadScrenplay() {
		       playsolosscreen = new PlaysolosScreen();
	}

	public static void lanchmainscreen() {
		if(music) Assets.musicspash.setVolume(1);
		((Game) Gdx.app.getApplicationListener()).setScreen(mainscreen);
    Gdx.graphics.setResizable(true);
	}
	public static void lanchPlaysolosScreen() {
		if(music)Assets.musicspash.setVolume(0.2f);
		((Game) Gdx.app.getApplicationListener()).setScreen(playsolosscreen);
        Gdx.graphics.setResizable(false);

	}
	public static void lanchsplachScreen(){
		((Game) Gdx.app.getApplicationListener()).setScreen(spachscreen = new spachscreen());
	}

}
