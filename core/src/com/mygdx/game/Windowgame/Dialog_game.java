package com.mygdx.game.Windowgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Assets;

/**
 * Created by HP on 17/03/2019.
 */

public class Dialog_game extends Windowpro {
    public ImageButton accepter = new ImageButton(Assets.accepting);
    ImageButton refuse = new ImageButton(Assets.refuser);

    public Dialog_game(String title) {
        super(title, Color.BLACK);
        initialisation();
    }

    private void initialisation() {
        refuse.addListener(new ClickListener(){
            public void clicked (InputEvent event, float x, float y) {
                  Close();
            }}
            );
        this.defaults().expand().center();
        this.row().bottom().height(80).padBottom(15); 
        this.add(accepter);this.add(refuse);
        this.row();
        this.pack();
    }
}
