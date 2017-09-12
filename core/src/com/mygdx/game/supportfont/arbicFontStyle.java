package com.mygdx.game.supportfont;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class arbicFontStyle{
	FileHandle File = Gdx.files.internal("fonts/jf_flat.fnt");
	private  BitmapFont font = new BitmapFont(File);
	private BitmapFont fontsmal = new BitmapFont(File);
	private BitmapFont fontBig = new BitmapFont(Gdx.files.internal("fonts/arabic.fnt"));
	private  BitmapFont fontchar = new BitmapFont(Gdx.files.internal("fonts/char3.fnt"));


	public arbicFontStyle(){
	    font.getData().setScale(0.75f);
	    fontsmal.getData().setScale(0.5f);
	}
	public BitmapFont getFont() {
		return font;
	}
	public BitmapFont getFont2(){
		return fontBig;
	}
	public BitmapFont getSmalFont(){return fontsmal;}
	public BitmapFont getfontchar(){return fontchar;}

	public TextButtonStyle getButtonStyleA(Drawable up, Drawable down) {
		TextButtonStyle ButtonStyleA = new TextButtonStyle();
		ButtonStyleA.font=getFont();
		ButtonStyleA.up=up;
		ButtonStyleA.down=down;
		return ButtonStyleA;
	}
	public TextButtonStyle getButtonStyleB(Drawable up, Drawable down) {
		TextButtonStyle ButtonStyleA = new TextButtonStyle();
		ButtonStyleA.font=getFont2();
		ButtonStyleA.up=up;
		ButtonStyleA.down=down;
		return ButtonStyleA;
	}
	public TextButtonStyle getButtonStyleC(Drawable up, Drawable down,Color color){
		TextButtonStyle ButtonStyleA = new TextButtonStyle();
		ButtonStyleA.font=fontchar;
		ButtonStyleA.up=up;
		ButtonStyleA.down=down;
		ButtonStyleA.fontColor=color;
		return ButtonStyleA;
	}
	

	
	public CheckBoxStyle getBoxStyleA(Drawable checkboxOff, Drawable checkboxOn) {
		CheckBoxStyle BoxStyleA = new CheckBoxStyle();
		BoxStyleA.font=getFont();
		BoxStyleA.checkboxOff=checkboxOff;
		BoxStyleA.checkboxOn=checkboxOn;
		return BoxStyleA;
	}

	
	public WindowStyle getWindowStyleA( Color titleFontColor, Drawable background){
		WindowStyle WindowStyleA = new WindowStyle();
		WindowStyleA.titleFont=getFont();
		WindowStyleA.background=background;
		WindowStyleA.titleFontColor=titleFontColor;
		return WindowStyleA;
	}
	
	public LabelStyle getLabelStyleA() {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=getFont();
		return LabelStyleA;
	}
	public LabelStyle getLabelStyleASmall() {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=getSmalFont();
		return LabelStyleA;
	}
	public LabelStyle getLabelStyleASmall(Color color) {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=getSmalFont();
		LabelStyleA.fontColor=color;
		return LabelStyleA;
	}

	 public LabelStyle getLabelStyleA(Color fontColor) {
		 LabelStyle LabelStyleA = new LabelStyle();
		 LabelStyleA.fontColor=fontColor;
		 LabelStyleA.font=getFont();
		 return LabelStyleA;
	 }
	public LabelStyle getLabelStyleC(Color fontColor, Drawable background) {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.fontColor=fontColor;
		LabelStyleA.background=background;
		LabelStyleA.font=fontchar;
		return LabelStyleA;
	}
	public LabelStyle getLabelStyleA( Color fontColor , Drawable background) {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=getFont();
		LabelStyleA.fontColor=fontColor;
		LabelStyleA.background=background;
		return LabelStyleA;
	}

	public LabelStyle getLabelStyleB(Color color) {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=fontBig;
		LabelStyleA.fontColor=color;
		return LabelStyleA;
	}
	public LabelStyle getLabelStyleB(Color color,Drawable background) {
		LabelStyle LabelStyleA = new LabelStyle();
		LabelStyleA.font=fontBig;
		LabelStyleA.fontColor=color;
		LabelStyleA.background=background;
		return LabelStyleA;
	}


	public ScrollPane.ScrollPaneStyle ScrollPaneStyleA(){
		ScrollPane.ScrollPaneStyle scrollPaneStyle = new ScrollPane.ScrollPaneStyle();
		return  scrollPaneStyle;
	}

}
