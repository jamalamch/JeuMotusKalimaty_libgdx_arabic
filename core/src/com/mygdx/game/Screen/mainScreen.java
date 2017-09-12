package com.mygdx.game.Screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Windowgame.SettingsLayer;
import com.mygdx.game.Windowgame.help;
import com.mygdx.game.supportfont.ArFont;
import com.mygdx.game.supportfont.arbicFontStyle;


public class mainScreen extends BaseScreenAdapter {
	public static ArFont arFont;
	public  static arbicFontStyle arbicFontStyle ;
	private  float x= MyGdxGame.x,y=MyGdxGame.y;
	private  float RATE=MyGdxGame.RATA ;
	private  final String ARABIC_LANGUAGE = "   العب    ";
    private  final String ARABIC_exit = "   خروج   ";
	private SettingsLayer Sestting;
	boolean button1marche = true;
	private ImageButton buttonsestting;
	private ImageButton buttonhelp;
	public static Image backwindows;
	private TextButton ButtonStar;
	private TextButton ButtonExite;
	private Label Score;

	public mainScreen(){
		super();
		this.mStage = new Stage();
		arbicFontStyle = new arbicFontStyle();
		arFont= new ArFont();
		Image back1 = new Image(Assets.background);
		back1.setSize(x, y);
		back1.setPosition(x/2, y/2,Align.center);
		mStage.addActor(back1);
		affichebuttonStar();
    }
	@Override
	public void show() {
		Gdx.input.setInputProcessor(mStage);
		Score.setText(MyGdxGame.getScore());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0.24f,0.24f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 mStage.draw();
		 mStage.act();
	}
	
    public void affichebuttonStar() {
    	button1marche =false;
		arbicFontStyle.getFont2().getData().setScale(MyGdxGame.RATA);
		ButtonStar = new TextButton(arFont.getText(ARABIC_LANGUAGE), arbicFontStyle.getButtonStyleB(Assets.buttonsStar, Assets.buttonsStarclick));
    	ButtonStar.setSize(300*MyGdxGame.RATA, 140*MyGdxGame.RATA);
    	ButtonStar.setPosition(x/2, y/2,Align.center);
    	ButtonStar.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float y, float x) {
					MyGdxGame.lanchPlaysolosScreen();
			}
		});
    	ButtonExite = new TextButton(arFont.getText(ARABIC_exit), arbicFontStyle.getButtonStyleB(Assets.buttonsStar, Assets.buttonsStarclick));
    	ButtonExite.setSize(290*MyGdxGame.RATA, 140*MyGdxGame.RATA);
    	ButtonExite.setPosition(x/2, ButtonStar.getY()-120*RATE,Align.center);
    	ButtonExite.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float y, float x) {
				Gdx.app.exit();
    		}});
		final help Help = new help();
		Help.setScale(RATE);
		Help.setSize(520, 630);
		Help.setPosition((x-520*RATE)/2, (y-630*RATE)/2);
		buttonhelp = new ImageButton(Assets.buttoninfostar);
		buttonhelp.setBounds(x-x/10, 0, x/10, x/10);
		buttonhelp.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
					Help.Open();backwindows.setVisible(true);
			}
		});
		
		


		buttonsestting= new ImageButton( Assets.buttonSetting);
          buttonsestting.setBounds(x-x/10, y-x/10, x/10, x/10);
		Sestting = new SettingsLayer();
		Sestting.setScale(RATE);
		Sestting.setSize(500, 600);
        Sestting.setPosition((x-500*RATE)/2, (y-600*RATE)/2);
        buttonsestting.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float y, float x) {
				    backwindows.setVisible(true); Sestting.Open();
            }
        });
        arbicFontStyle.getfontchar().getData().setScale(RATE);
        Score=new Label("",arbicFontStyle.getLabelStyleC(Color.FOREST,Assets.Score));
        Score.setAlignment(Align.center);
        Score.setBounds(10*RATE, y-70*MyGdxGame.RATA,300*MyGdxGame.RATA,60*MyGdxGame.RATA);
        backwindows = new Image(Assets.backgrandwindows);
        backwindows.setSize(x,y);
        backwindows.setPosition(x/2, y/2,Align.center);
        backwindows.setVisible(false);
        backwindows.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Sestting.Close(); Help.Close(); backwindows.setVisible(false);
			}
		});
		mStage.addActor(ButtonStar);
        mStage.addActor(ButtonExite);
        mStage.addActor(buttonsestting);
        mStage.addActor(buttonhelp);
        mStage.addActor(Score);
        mStage.addActor(backwindows);
        mStage.addActor(Sestting);
        mStage.addActor(Help);

    }
	@Override
	public void resize(int width, int height) {
		super.resize(width,height);
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
