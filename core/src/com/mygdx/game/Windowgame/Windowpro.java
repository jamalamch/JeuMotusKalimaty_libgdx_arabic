package com.mygdx.game.Windowgame;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screen.mainScreen;

import java.util.Random;


/**
 * Created by HP on 19/03/2019.
 */

public class Windowpro extends Window {
	private static Random R = new Random();
    public Windowpro(String title,Color color) {
        super(mainScreen.arFont.getText(title), mainScreen.arbicFontStyle.getWindowStyleA(color, Assets.windows));
        super.getTitleLabel().setAlignment(Align.bottom);
        super.getTitleLabel().getStyle().background=Assets.windowsladel;
        this.setVisible(false);
        setKeepWithinStage(false);   
        this.addAction(Actions.alpha(0));
    }
    public void Open(){
        int i;
        //if(Gdx.app.getType() == Desktop)
     //       i= R.ints(-(int)(this.getHeight()*this.getScaleX()), MyGdxGame.y).findAny().getAsInt();
     //   else
        i = R.nextInt(MyGdxGame.y);
        if(!this.isVisible()){
    		this.addAction(Actions.sequence(Actions.moveTo(MyGdxGame.x,i),Actions.visible(true),Actions.parallel(Actions.alpha(1, 0.3f),Actions.moveTo(this.getX(), this.getY(),0.3f))));
    	}
    }
    public void Close() {
        int i;
       // if(Gdx.app.getType() == Desktop)
       //     i= R.ints(-(int)(this.getWidth()*this.getScaleX()), MyGdxGame.x).findAny().getAsInt();
       // else
        i = R.nextInt(MyGdxGame.x);
    	if(this.isVisible()) {
    		this.addAction(Actions.sequence(Actions.parallel(Actions.alpha(0, 0.3f),Actions.moveTo(i, MyGdxGame.y,0.3f)),Actions.visible(false),Actions.moveTo(this.getX(), this.getY())));
    	}
    }
}

