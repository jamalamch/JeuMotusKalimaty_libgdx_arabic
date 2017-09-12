package com.mygdx.game.buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.supportfont.arbicFontStyle;


/**
 * Created by HP on 04/03/2019.
 */

public class clavierarabic extends Table {
    private Array<buttondeclavier> lesbuttons = new Array<buttondeclavier>();
    private static   char[] tabLetrres= new char[]{'ض','ص','ث','ق','ف','غ','ع','ه','خ','ح','ج',
            'د','ش','س','ي','ب','ل','ا','ت','ن', 'م','ك',
            'X','ذ','ط','ء','ر','ى','ة','و','ز','ظ'};

    public clavierarabic(float size, arbicFontStyle font){
        super();
        super.background(Assets.clavierbackground);
        buttondeclavier.setStyle(font.getButtonStyleC(Assets.buttonclavier,Assets.buttonclaviercliked,Color.GRAY));
        
        for(char c:tabLetrres){
            final buttondeclavier button = new buttondeclavier(String.valueOf(c));
            lesbuttons.add(button);
        }

        addbuttonintotable(size);
    }
    public void addbuttonintotable(float size){
        this.defaults().center().width(MyGdxGame.x/11).height(size*100f);
        this.row();
        for(buttondeclavier B : lesbuttons){
            if(B.getLettre().equals("X")){
                this.add(B).colspan(2).width(MyGdxGame.x/6);
                B.setColor(Color.RED);
            }
            else this.add(B);
            if(B.getLettre().equals("ج")  || B.getLettre().equals("ك"))
                this.row();
        }
        this.setFillParent(false);
        this.pack();
    }
    public Array<buttondeclavier> setbuttons(){
        return lesbuttons;
    }
}
