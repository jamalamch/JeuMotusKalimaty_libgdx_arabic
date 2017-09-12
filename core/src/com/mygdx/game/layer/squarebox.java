package com.mygdx.game.layer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.supportfont.arbicFontStyle;

import java.util.Random;


/**
 * Created by HP on 07/03/2019.
 */

public class squarebox extends Table {
    private int X,Y;
    public box[][] BOX;
    public  squarebox(int x, int y, arbicFontStyle font){
        super();
        box.setLabelStyledefu(font.getLabelStyleC(Color.CYAN,Assets.box));
        box.setLabelStyleselect(font.getLabelStyleC(Color.BLUE,Assets.box));
        box.setLabelStylevalid(font.getLabelStyleC(Color.ORANGE,Assets.boxtrue));
        box.setLabelStylefalse(font.getLabelStyleC(Color.RED,Assets.boxfalse));
        box.setLabelStylemalpla(font.getLabelStyleC(Color.MAROON,Assets.boxmalplace));
        this.X=x;this.Y=y;
        this.BOX=new box[X][Y];
        for(int i =0;i<X;i++)
            for(int j=0;j<Y;j++)
                  BOX[i][j]=new box();
         affichelesbox(X,Y);
         super.background(Assets.backgrandsqure);
    }
    public void affichelesbox(int X,int Y){
     //   this.setDebug(true);
        this.X=X;this.Y=Y;
        int taille = (MyGdxGame.x)/(Y+2);
        if(taille > (MyGdxGame.y)/(2*X))
            taille = (MyGdxGame.y )/(2*X);
        this.defaults().center().width(taille).height(taille);
        this.center();
        this.row();
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                 this.add(BOX[i][j]);
            }
            row();
        }
        this.setFillParent(false);
        this.pack();
    }
    public void reaffichage(final String mot){
                 Random r =new Random();
                 int indice ;
                 int i;
                for(i = 0; i<X;i++)
                    for(int j = 0; j<Y;j++)
                    {
                        BOX[i][j].setText(" - ");
                        BOX[i][j].selected(false);
                    }
                    i=0;
                    do {
                        indice = r.nextInt(mot.length());
                        BOX[0][Y - indice - 1].selected(true);
                        BOX[0][Y - indice - 1].setText(String.valueOf(mot.charAt(indice)));
                        i++;
                    }while (i < mot.length()/3);
    }
}
