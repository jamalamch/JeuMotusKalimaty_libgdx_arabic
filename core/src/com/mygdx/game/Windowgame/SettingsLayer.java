package com.mygdx.game.Windowgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screen.mainScreen;
import com.mygdx.game.supportfont.arbicFontStyle;

public class SettingsLayer extends Windowpro{
	
    private  arbicFontStyle ArabicFont ;
	private  final String TEXT_SOUND =        " الموسيقى";
	private  final String TEXT_NOMBERmot=     "  عدد الكلمات  ";
	private  final String TEXT_NumberdeSe =   "عدد المحاولات";
	private  final String TEXT_NIVEU =        "صعوبة التحدي";
	private  final String TEXT_lounge_mot =   "  طول الكلمة   ";
	private  final String TEXT_enregest =     "حفض";
	private  final String TEXT_annul =        "الغاء";
	private Table table;

	
	public SettingsLayer() {
		super("الاعدادات",Color.CHARTREUSE);
		ArabicFont = new arbicFontStyle();
		buildElements();
	}


	private void buildElements()
	{
		 final SliderStyle styleSilder = new SliderStyle(Assets.backknob, Assets.knob);
		// ---------------------------------------------------------------
		// Elements
		// ---------------------------------------------------------------
		final Label.LabelStyle StyleLadel= ArabicFont.getLabelStyleA();
		final CheckBox.CheckBoxStyle  BoxStyle = ArabicFont.getBoxStyleA(Assets.sonOF, Assets.sonON);

		final   CheckBox sonONOF = new CheckBox(mainScreen.arFont.getText(TEXT_SOUND),BoxStyle);
		sonONOF.setChecked(!MyGdxGame.isMusic());
		sonONOF.addListener(new ClickListener()
	{
		@Override
		public void clicked(InputEvent event, float x, float y)
		{
			if(sonONOF.isChecked())
			Assets.musicspash.pause();
			else
			Assets.musicspash.play();
			MyGdxGame.setMusic(!sonONOF.isChecked());
		}

	});
        final Slider slider = new Slider(0, 4, 1, false, styleSilder);
        slider.setValue(MyGdxGame.getDifficulte());
		final Label niveaugame = new Label(mainScreen.arFont.getText(TEXT_NIVEU),StyleLadel);
		  //numbremot.
		final plusadnmoin changenombermot = new plusadnmoin(MyGdxGame.getNombermot(),10,3,mainScreen.arFont.getText(TEXT_NOMBERmot),StyleLadel);
		final plusadnmoin changeloungmot = new plusadnmoin(MyGdxGame.getlongmot(),8,3,mainScreen.arFont.getText(TEXT_lounge_mot),StyleLadel);
		final plusadnmoin changenomberte = new plusadnmoin(MyGdxGame.getNombertent(),8,4,mainScreen.arFont.getText(TEXT_NumberdeSe),StyleLadel);

		final Label paddingenregest = new Label(mainScreen.arFont.getText(TEXT_enregest),StyleLadel);
		paddingenregest.setColor(Color.BLUE);
		final Label paddingannul = new Label(mainScreen.arFont.getText(TEXT_annul),StyleLadel);
        paddingannul.setColor(Color.RED);
		paddingannul.addListener(new ClickListener() {
									 @Override
									 public void clicked(InputEvent event, float y, float x) {
										 SettingsLayer.super.setVisible(false);
                                         paddingannul.setColor(Color.RED);
										 mainScreen.backwindows.setVisible(false);
									 }

									 @Override
									 public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                         paddingannul.setColor(Color.FOREST);
										 return super.touchDown(event, x, y, pointer, button);
									 }
								 }
		);
		paddingenregest.addListener(new ClickListener() {
										@Override
										public void clicked(InputEvent event, float y, float x) {
											MyGdxGame.setlongmot(changeloungmot.getparameter());
											MyGdxGame.setNombertent(changenomberte.getparameter());
											MyGdxGame.setNombermot(changenombermot.getparameter());
											MyGdxGame.setDifficulte((int)slider.getValue());
											MyGdxGame.setDifficulte((int)slider.getValue());
											SettingsLayer.super.setVisible(false);
											mainScreen.backwindows.setVisible(false);
											paddingenregest.setColor(Color.BLUE);
											MyGdxGame.update();
										}

										@Override
										public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
											paddingenregest.setColor(Color.SKY);
											return super.touchDown(event, x, y, pointer, button);
										}
									}
		);
		paddingenregest.setHeight(20);

		// ---------------------------------------------------------------
		// Table 
		// ---------------------------------------------------------------
		table = new Table();
		table.columnDefaults(0).center();
		table.columnDefaults(1).left();
		table.setFillParent(true);
		table.row();
		table.add(sonONOF).colspan(2);
		table.row();
		table.add(niveaugame).colspan(2);
		table.row();
		table.add(slider).colspan(2).width(300);
		table.row();
		table.add(changenombermot).colspan(2);
		table.row();
		table.add(changeloungmot).colspan(2);
		table.row();
	    table.add(changenomberte).colspan(2);
		table.row().center();
	    table.add(paddingannul);
	    table.add(paddingenregest);
	    table.row();


		table.setFillParent(true);
		table.pack();

		addActor(table);		
	}

	/**
	 * Catch escape key.
	 * 
	 */

	class plusadnmoin extends Table {
  	private int max,min;
  	private    ImageButton pluslettre = new ImageButton( Assets.buttonplus,Assets.buttonplusclick);
	private    ImageButton moinlettre = new ImageButton(Assets.buttonmoin,Assets.buttonmoinclick);
	private Label numbremot ;
	private Label Text;

		plusadnmoin(int defu,int M, int m,String Textlabel,Label.LabelStyle StyleLadel){
			max=M;min=m;
			numbremot = new Label(String.valueOf(defu),StyleLadel);
			Text = new Label(Textlabel,StyleLadel);
			initialisation();

		}

        public void initialisation(){
		  numbremot.setWidth(moinlettre.getWidth());
		  numbremot.setAlignment(Align.center);
            pluslettre.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				int x1=Integer.valueOf(String.valueOf(numbremot.getText()))+1;
				if(x1 <= max && x1>=min){
				numbremot.setText(x1);
				}
			}
		});
            moinlettre.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				int x1=Integer.valueOf(numbremot.getText().toString())-1;
				if(x1<=max && x1>=min) {
					numbremot.setText(x1);
				}
			}
		});
			row().pad(5);
			add(moinlettre).left();
			add(numbremot).center();
			add(pluslettre).right();
			add(Text).left();
			pack();
	}
	public int getparameter(){
       return  	Integer.valueOf(String.valueOf(numbremot.getText()));
	}
	}
}
