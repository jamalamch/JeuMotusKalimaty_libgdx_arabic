package com.mygdx.game.Screen;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;

/**
 * Created by HP on 23/03/2019.
 */

public abstract class BaseScreenAdapter extends ScreenAdapter {
    protected Stage mStage;
    //==============================================================
    // METHODS
    //==============================================================
    public BaseScreenAdapter() {
            super();
    }

    public Stage getStage() {
        return mStage;
    }

    @Override
    public void dispose() {
        super.dispose();
        mStage.dispose();
    }

    @Override
    public void resize(int width, int height){
        if(width != MyGdxGame.x || height != MyGdxGame.y) {
            MyGdxGame.x = width;
            MyGdxGame.y = height;
            MyGdxGame.RATA = ((width > height)?(float)height/720:(float)width/ 640);
            MyGdxGame.loadScrennmain();
            MyGdxGame.loadScrenplay();
            MyGdxGame.lanchmainscreen();
        }
    }
}