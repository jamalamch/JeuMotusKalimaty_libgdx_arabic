package com.mygdx.game.layer;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;

/**
 * Created by HP on 07/03/2019.
 */

class box extends Label{
    private static  LabelStyle labelStyledefu;
    private static  LabelStyle labelStyleselect;
    private static  LabelStyle labelStylevalid;
    private static LabelStyle  labelStylefalse;
    private static LabelStyle  labelStylemalpla;

    public box(){
        super(" _ ", labelStyledefu);
        this.setAlignment(Align.center);
    }

    public void setText(String c){
        super.setText(c);
    }

    public void selected(boolean test){
                if(test)
                    this.setStyle(labelStyleselect);
                else
                    this.setStyle(labelStyledefu);
    }
    public void setvalide(boolean test){
        if(test){
            this.setStyle(labelStylevalid);
            Assets.letterbienplace.play();
        }
        else{
            this.setStyle(labelStylefalse);
            Assets.letterfalse.play();
        }
    }
    public void setmalplace(){
        this.setStyle(labelStylemalpla);
        Assets.lettermalplace.play();
    }

    public static void setLabelStyleselect(LabelStyle labelStyleselect) {
        box.labelStyleselect = labelStyleselect;
    }
    public static void setLabelStylevalid(LabelStyle labelStylevalid) {
        box.labelStylevalid = labelStylevalid;
    }
    public static void setLabelStyledefu(LabelStyle labelStyledefu) {
        box.labelStyledefu = labelStyledefu;
    }
    public static void setLabelStylefalse(LabelStyle labelStylefalse) {
        box.labelStylefalse = labelStylefalse;
    }
    public static void setLabelStylemalpla(LabelStyle labelStylemalpla) {
        box.labelStylemalpla = labelStylemalpla;
    }
}
