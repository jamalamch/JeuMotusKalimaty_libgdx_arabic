package com.mygdx.game.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Assets;
import com.mygdx.game.layer.gameonplayer;


/**
 * Created by HP on 03/03/2019.
 */

public class buttondeclavier extends TextButton {
    private String lettre;
    private static TextButtonStyle style;
    public static gameonplayer game;

    public buttondeclavier(String C) {
        super(String.valueOf(C), style);
        this.lettre=C;
        this.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                   game.saiser(getLettre());
                   Assets.clickbutton.play();
            }
        });
    }

    public static void setStyle(TextButtonStyle style) {
        buttondeclavier.style = style;
    }

    public String getLettre() {
        return lettre;
    }
}
