package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by HP on 19/03/2019.
 */

public class Assets {
    public static Texture background;
    public static Texture logo;
    public static Texture backgrandwindows;

    public static Drawable windows;
    public static Drawable windowsladel;
    public static Drawable buttonsStar;
    public static Drawable buttonsStarclick;
    public static Drawable buttoninfostar;
    public static Drawable buttonSetting;
    public static Drawable buttonplus;
    public static Drawable buttonplusclick;
    public static Drawable buttonmoin;
    public static Drawable buttonmoinclick;
    public static Drawable backknob;
    public static Drawable knob;
    public static Drawable accepting;
    public static Drawable refuser;
    public static Drawable sonON;
    public static Drawable sonOF;
    public static Drawable box;
    public static Drawable boxfalse;
    public static Drawable boxtrue;
    public static Drawable boxmalplace;
    public static Drawable buttonclavier;
    public static Drawable buttonclaviercliked;
    public static Drawable clavierbackground;
    public static Drawable timer;
    public static Drawable Score;
    public static Drawable buttonplay;
    public static Drawable buttonplayClick;
    public static Drawable backgrandsqure;
    public static Drawable frame;
    public static Drawable exite;

    
    
    public static Music musicspash;
    public static Sound lemottrue;
    public static Sound lemotfalse;
    public static Sound letterbienplace;
    public static Sound lettermalplace;
    public static Sound letterfalse;
    public static Sound clickbutton;
    public static Sound motpasexist;




    public static  void loadpro(){
        background =new Texture(Gdx.files.internal("image/backgrand.jpg"));
        logo = new Texture(Gdx.files.internal("image/logo.png"));
    }
    public static void load (){
        windows = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/windows.png")));
        windowsladel  = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/windowsladel.png")));
        buttonsStar = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonsStar.png")));
        buttonsStarclick =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonsStarclick.png")));
        buttoninfostar = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/buttoninfostar.png")));
        buttonSetting =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonSetting.png")));
        buttonplus = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/buttonplus.png")));
        buttonplusclick =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonplusclick.png")));
        buttonmoin = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/buttonmoin.png")));
        buttonmoinclick =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonmoinclick.png")));
        backknob = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/backknob.png")));
        knob =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/knob.png")));
        accepting =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/accepting.png")));
        refuser =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/refuser.png")));
        sonON =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/sonON.png")));
        sonOF =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/sonOF.png")));
        box =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/box.png")));
        boxfalse = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/boxfalse.png")));
        boxtrue =  new TextureRegionDrawable(new Texture(Gdx.files.internal("image/boxtrue.png")));
        boxmalplace = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/boxmalplace.png")));
        buttonclavier = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/buttonclavier.png")));
        buttonclaviercliked = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/buttonclaviercliked.png")));
        timer  = new TextureRegionDrawable( new Texture(Gdx.files.internal("image/timer.png")));
        Score = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/score.png")));
        clavierbackground  = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/clavierbackground.png")));
        buttonplay  = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonplay.png")));
        buttonplayClick = new TextureRegionDrawable(new Texture(Gdx.files.internal("image/buttonplayClick.png")));
        backgrandwindows= new Texture(Gdx.files.internal("image/backgrandwindows.png"));
        backgrandsqure= new TextureRegionDrawable(new Texture(Gdx.files.internal("image/backgrandsqure.png")));
        frame= new TextureRegionDrawable(new Texture(Gdx.files.internal("image/frame.png")));
        exite= new TextureRegionDrawable(new Texture(Gdx.files.internal("image/exite.png")));

        musicspash =  Gdx.audio.newMusic(Gdx.files.internal("sound/musicspash.mp3"));musicspash.setLooping(true);

        lemottrue = Gdx.audio.newSound(Gdx.files.internal("sound/trovemot.ogg"));
        lemotfalse = Gdx.audio.newSound(Gdx.files.internal("sound/pastrove.ogg"));
        letterbienplace = Gdx.audio.newSound(Gdx.files.internal("sound/letterexist.mp3"));
        motpasexist = Gdx.audio.newSound(Gdx.files.internal("sound/motpasexiste.mp3"));
        lettermalplace = Gdx.audio.newSound(Gdx.files.internal("sound/mallplace.wav"));
        letterfalse = Gdx.audio.newSound(Gdx.files.internal("sound/nexiste.wav"));
        clickbutton = Gdx.audio.newSound(Gdx.files.internal("sound/button_click.ogg"));
    }
}
