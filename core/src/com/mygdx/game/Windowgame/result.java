package com.mygdx.game.Windowgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screen.mainScreen;


/**
 * Created by HP on 18/03/2019.
 */

public class result extends Windowpro {

    private Label Nombermot ;
    private Label NombermotTrover;
    private Label timeutilese;
    private Label nomberattempts;
    private Label solin;
    private Label scorefinal;
    private Table table = new Table();
    public Label paddinsuivant;
    public Label paddingannul;

    public result() {
        super(" نتيجة الاختبار ",Color.BROWN);
        setVisible(false);
        Label.LabelStyle style =  mainScreen.arbicFontStyle.getLabelStyleA(Color.BLACK);
        Nombermot = new Label("",style);
        NombermotTrover = new Label("",style);
        timeutilese = new Label("",style);
        nomberattempts = new Label("",style);
        solin= new Label("-------------------------",style);
        scorefinal = new Label("",style);
        paddinsuivant = new Label(mainScreen.arFont.getText(" تحدي جديد "),style);
        paddingannul = new Label(mainScreen.arFont.getText(" خروج "),style);

        table.columnDefaults(0).center();
        table.row();
        table.add(Nombermot).colspan(2);
        table.row();
        table.add(NombermotTrover).colspan(2);
        table.row();
        table.add(timeutilese).colspan(2);
        table.row();
        table.add(nomberattempts).colspan(2);
        table.row();
        table.add(solin).colspan(2);
        table.row();
        table.add(scorefinal).colspan(2);
        table.row().center();
        table.add(paddinsuivant);
        table.add(paddingannul);
        table.row();
        table.setFillParent(true);
        table.pack();
        addActor(table);
    }
    public void afficherleresult(int nombermot ,int nombermottrove,int timeutiliseer,int getNomberfot,int calculerScor){
        Open();
        Nombermot.setText(nombermot+" : "+mainScreen.arFont.getText(" عدد الكلمات "));
        NombermotTrover.setText(nombermottrove+" : "+mainScreen.arFont.getText(" الكلمات الصحيحية "));
        timeutilese.setText(timeutiliseer+" : "+mainScreen.arFont.getText(" الوقت المحقق "));
        nomberattempts.setText(getNomberfot+" : "+mainScreen.arFont.getText(" الاخطاء "));
        scorefinal.setText(calculerScor+" : "+mainScreen.arFont.getText(" مجموع النقط "));
        MyGdxGame.setScore(calculerScor);
    }
}
