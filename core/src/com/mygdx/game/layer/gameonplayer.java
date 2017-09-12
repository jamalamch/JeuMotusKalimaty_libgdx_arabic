package com.mygdx.game.layer;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.sql.SQLiteGdxException;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Assets;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.BaseDonnees.BaseDonnes;
import com.mygdx.game.BaseDonnees.Mot;
import com.mygdx.game.Screen.PlaysolosScreen;
import com.mygdx.game.Screen.mainScreen;
import com.mygdx.game.Windowgame.result;
import com.mygdx.game.buttons.clavierarabic;
import com.mygdx.game.supportfont.arbicFontStyle;

import static com.mygdx.game.MyGdxGame.RATA;
import static com.mygdx.game.MyGdxGame.x;
import static com.mygdx.game.MyGdxGame.y;

import java.io.IOException;

/**
 * Created by HP on 07/03/2019.
 */

public class gameonplayer extends Table {
    private  int tempstotale;
    private  int nomberlettre;
    private  int nombertentat;

    private int nomberfot;
    private int nombermot ;
    private int nombermottrove;
    private int timeutiliseer;

    private int chartrove;


    private Table above;

    public  boolean stop ,saiser;
    private int time;
    private Timer timer1 ;
    private Timer timer2;
    public  Timer.Task task;

    private Label temps;
    private Label nomber;
    private Label notification;
    private Button exite;
    private   arbicFontStyle font;


    private clavierarabic clavier;
    private squarebox squarebox;

    private   ImageButton play;

    private String mot;
    private int i=0,j=0;
    private char [] lemotsaise;
    private result result1;

    public gameonplayer(){
            super();
            font = new arbicFontStyle();
            initialisation();
        }
        public void affichage(){
            stop=false;
            nombermot =0;
            nombermottrove =0;
            timeutiliseer=0;
            nomberfot=0;
            chartrove =0;
            nomberlettre= MyGdxGame.getlongmot();
            tempstotale = MyGdxGame.getTemptotals();
            nombertentat = MyGdxGame.getNombertent();
            update();
            temps.setText("00:00");
            nomber.setText(nombermot+"/"+MyGdxGame.getNombermot());
            timer1= new Timer();
            timer2= new Timer();
            play.setVisible(true);
            notification.setVisible(true);
            notification.setText(mainScreen.arFont.getText(" ابدا اللعبة "));
            clavier.addAction(Actions.alpha(0));clavier.setVisible(true);
            squarebox.addAction(Actions.alpha(0));squarebox.setVisible(true);
            Star();
            result1.addAction(Actions.alpha(0));
        }

        @SuppressWarnings("static-access")
		public void Star(){
            task = new Timer.Task(){
                @Override
                public void run() {
                    if(time >= 0 && stop){
                        time--;
                        temps.setText(String.format( "%02d:%02d" ,time / 60, time % 60));
                        if(time == 0)
                            affichelesresulta();
                    }
                }
            };
            time=tempstotale;
            timer1.schedule(task, 1,1);
        }
        public void setnovelmot (){
            timeutiliseer+=tempstotale-time;
            time=tempstotale;
            this.i=0;this.j=nomberlettre-1;
            if(nombermot<MyGdxGame.getNombermot()){
                mot= Mot.genererMot(PlaysolosScreen.tabmot).getMot();
                squarebox.reaffichage(mot);
                stop=true;
                saiser=true;
                nomber.setText((++nombermot)+"/"+MyGdxGame.getNombermot());
                afficheclavier();
                affichesquarebox();
                notification.setVisible(false);
            }
            else{
                stop=false;
                saiser=false;
                notification.setVisible(false);
                setresulta();
            }
            play.setVisible(false);
        }

    public void updategame() {
        nombermot =0;
        nombermottrove =0;
        timeutiliseer=0;
        tempstotale = MyGdxGame.getTemptotals();
        nombertentat = MyGdxGame.getNombertent();
        nomberlettre= MyGdxGame.getlongmot();
        nomber.setText(nombermot+"/"+MyGdxGame.getNombermot());
        play.setVisible(true);
        notification.setVisible(true);
        notification.setText(mainScreen.arFont.getText(" ابدا اللعبة "));
        affichesquarebox();
    }

        public int calculerScor(){
            int Score= 20*nombermottrove*(5-MyGdxGame.getDifficulte())*nomberlettre - (nomberfot+(timeutiliseer/20))*nombertentat;
            return (Score<0)?chartrove:Score+chartrove;
    }
    public void afficheclavier(){
            if(stop) {
                clavier.addAction(Actions.alpha(1, 0.7f));
            }
            else {
                clavier.addAction(Actions.alpha(0, 1));
            }


    }
    public void affichesquarebox(){
        if(stop){
            squarebox.addAction(Actions.alpha(1,1));
        }
        else{
            squarebox.addAction(Actions.alpha(0,0.5f));
        }
    }

    public  void saiser(final String c) {
        if ( saiser){
            if (c.charAt(0) == 'X') {
                if (j < nomberlettre - 1) {
                    squarebox.BOX[i][j].selected(false);
                    j++;
                    squarebox.BOX[i][j].setText(" _ ");
                    squarebox.BOX[i][j].selected(true);
                }
            } else if (i < nombertentat) {
                squarebox.BOX[i][j].setText(c);
                squarebox.BOX[i][j].selected(false);
                lemotsaise[nomberlettre - j - 1] = c.charAt(0);
                if (j == 0) {
                    if (i == nombertentat - 1) {
                        squarebox.BOX[i][j].selected(false);
                    } 
                     try {
                    	 
						//if(BaseDonnes.chercherlesmots(String.valueOf(lemotsaise))) fairetest();
                    	 if(BaseDonnes.chercherlesmotshamza(lemotsaise)) fairetest();
						else {
							Assets.motpasexist.play();
					        j = nomberlettre - 1;	  
					        i++;
	                        if (i == nombertentat ) affichelesresulta();
	                        else {
                            squarebox.BOX[i][j].selected(true);
                            saiser=true;
                            stop=true;
	                        }

						}
					} catch (SQLiteGdxException e) {
						e.printStackTrace();
					}
                    
                    return;
                } else j--;
                if (i < nombertentat) squarebox.BOX[i][j].selected(true);
            }
        }
    }
    @SuppressWarnings("static-access")
	public void fairetest() {
        final int I=i;
        saiser=false;
        timer2.clear();
        stop=false;
        timer2.schedule(new Timer.Task() {
            int J=0;
            boolean trove=true;
            @Override
            public void run() {
                if (mot.charAt(J) == lemotsaise[J] || charspesial(lemotsaise[J],mot.charAt(J))) {
                    squarebox.BOX[I][nomberlettre - J - 1].setvalide(true);
                    chartrove++;
                } else{
                    if(malpace(lemotsaise[J]))  squarebox.BOX[I][nomberlettre - J - 1].setmalplace();
                    else squarebox.BOX[I][nomberlettre - J - 1].setvalide(false);
                    trove=false;
                }
                if(!isScheduled())
                    if(trove) {
                        nombermottrove++;
                        notification.setVisible(true);
                        notification.setText(mainScreen.arFont.getText(" الاجابة صحيحة "));
                        Assets.lemottrue.play();
                        play.setVisible(true);
                        affichesquarebox();
                    }
                    else{
                        if (i == nombertentat ) affichelesresulta();
                        else{
                            squarebox.BOX[i][j].selected(true);
                            saiser=true;
                            stop=true;

                        }
                        addfolse();
                    }
                J++;
            }
        },0, 1,nomberlettre - 1);
        j = nomberlettre - 1;
        i++;
        System.out.println(mot);
        System.out.println(String.valueOf(lemotsaise));
    }
    private void addfolse() {
        nomberfot++;
    }

    public  void update(){
        this.i=0;this.j=nomberlettre-1;
        squarebox.clear();
        lemotsaise =new char[nomberlettre];
        squarebox.BOX=new box[nombertentat][nomberlettre];
        for(int i =0;i<nombertentat;i++)
            for(int j=0;j<nomberlettre;j++)
                squarebox.BOX[i][j]=new box();
        squarebox.affichelesbox(nombertentat,nomberlettre);
    }

    public boolean malpace(char c){
        for(char k : mot.toCharArray())
            if(c == k)
                return  true;
        return false;
    }
    public boolean charspesial(char c,char t){
        char [] charspesial;
        if(c =='ء' ){
            charspesial = new char[]{'ئ','ؤ','أ','إ'};
            for(char k : charspesial)
                if( k == t)
                    return true;}
        else if(c=='ا'){
            charspesial = new char[]{'أ','آ','إ'};
            for(char k : charspesial)
                if( k == t)
                    return true;
        }
        return false;
    }

    public void affichelesresulta(){
        saiser=false;
        stop=false;
        notification.setVisible(true);
        play.setVisible(true);
        Assets.lemotfalse.play();
        notification.setText(mainScreen.arFont.getText(
                  "  الاجابة الصحيحة : "+mot+" "
                        +"\n"
                        +" الاجابة خاطئة  "));
        affichesquarebox();
    }


    public void setresulta(){
        result1.afficherleresult(nombermot,nombermottrove,timeutiliseer,nomberfot,calculerScor());
    }

    public result getresulta() {
        return result1;
    }

    public void initialisation(){
        font.getFont().getData().setScale(MyGdxGame.RATA);
        font.getFont2().getData().setScale(MyGdxGame.RATA);
        font.getfontchar().getData().setScale(MyGdxGame.RATA);
        clavier = new clavierarabic(MyGdxGame.RATA,font);clavier.setVisible(false);
        squarebox = new squarebox(1,1,font);squarebox.setVisible(false);
        temps = new Label("",font.getLabelStyleA(Color.BROWN,Assets.timer));
        nomber = new Label("",font.getLabelStyleA(Color.FIREBRICK));
        exite = new Button(Assets.exite);
        exite.setSize(10*RATA,10*RATA);
        exite.addListener(new ClickListener() {
        	@Override
        	public void clicked(InputEvent event, float x, float y) {
                PlaysolosScreen.dialogexit.Open();
        	}
        });
        notification = new Label(mainScreen.arFont.getText(" ابدا اللعبة "),font.getLabelStyleB(Color.GOLDENROD,Assets.frame));
        notification.setAlignment(Align.center);
        temps.setAlignment(Align.left);
        play =new ImageButton(Assets.buttonplay,Assets.buttonplayClick);
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                setnovelmot();
            }
        });
        above = new Table();
        above.background(Assets.clavierbackground);
        above.row();
        above.add(exite).height(60*MyGdxGame.RATA).width(60*MyGdxGame.RATA);
        above.add(temps).left().width(MyGdxGame.x/4).padLeft(4).expandX();
        above.add(nomber).right().width(MyGdxGame.x/9).expandX();
        above.setFillParent(false);
        above.pack();
        above.addListener(new ClickListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if(stop)
                squarebox.addAction(Actions.sequence(Actions.alpha(0.3f,0.3f),Actions.alpha(0.3f,1),Actions.alpha(1,0.6f)));
            }
        });
        //this.setDebug(true);
       // this.padBottom(2);
        this.defaults().center().expand();
        this.row().height(70*MyGdxGame.RATA).top();
        this.add(above).prefWidth(9999);
        this.row();
        this.add(squarebox).bottom().pad(-5);
        this.row();
        this.add(notification).padTop(-450).width(x-10);
        this.row();
        this.add(play).height(100*MyGdxGame.RATA).width(100*MyGdxGame.RATA).padTop(-100);
        this.row();
        this.add(clavier).bottom();
        this.row();
        this.setFillParent(true);
        this.pack();

        result1=new result();
        result1.setScale(MyGdxGame.RATA);
        result1.setSize(500, 600);
        result1.setPosition((x-500*MyGdxGame.RATA)/2, (y-600*MyGdxGame.RATA)/2);
        result1.paddinsuivant.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float y, float x){
                updategame();
                result1.Close();
            }}
        );
        result1.paddingannul.addListener(new ClickListener(){
                                                     @Override
                                                     public void clicked(InputEvent event, float y, float x) {
                                                         getresulta().setVisible(false);
                                                         task.cancel();
                                                         MyGdxGame.lanchmainscreen();                                                     }
                                                 }
        );
    }
}
