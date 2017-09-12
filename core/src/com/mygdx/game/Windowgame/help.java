package com.mygdx.game.Windowgame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.Screen.mainScreen;

/**
 * Created by HP on 18/03/2019.
 */

public class help extends Windowpro{
    Tablehelp tablehelp = new Tablehelp();
    ScrollPane scrollPane = new ScrollPane(tablehelp,mainScreen.arbicFontStyle.ScrollPaneStyleA());

    public help() {
        super(" قواعد اللعب ",Color.CYAN);
        scrollPane.setSize(90,90);
        scrollPane.pack();
        add(scrollPane).padTop(30).padBottom(60);
    }
class Tablehelp extends Table{
    Label info1 = new Label(mainScreen.arFont.getText(
            "   أ-ؤ -ئ -ء : تعتبر كلها ء"
                    +"\n"
                    + "   -ا -أ -إ -آ : تعتبر كلها ا"
                    +"\n"
                    +"الحروف :"
                    +" \n"
                    +"الصحيح و الحروف الصحيحة في الموضع الخاطئ"
                    +" \n"
                    +" ثم الإشارة إلى الحروف الصحيحة في الموضع "
                    +"\n"
                    +"  عند إدخال كل كلمة يتم مقارنتها مع الكلمة الأصلية"
                    +"\n"
                    +" و حرف آخر من الكلمة ) ابتداءا من 5 حروف ("
                    +"\n"
                    +"  يتم إعطاء الحرف الأول من الكلمة"
                    + "\n"
                    +" في أقل عدد من المحاولات"
                    + "\n"
                    +"الهدف : إيجاد كلمة مكونة من عدد معين من الحروف"
                    + "\n"
                    + "  عدد الكلمات  : ابتداءا من 4 كلمات"
                    +"\n"
                    + "  عدد المحاولات : من 3 إلى 7 محاولات"
                    +"\n"
                    + "  طول الكلمات : من 2 إلى 8 حروف"
                    +"\n"
                    +" * سهل * متوسط * صعب "
                    +"\n"
                    + "  تتكون اللعبة من ثلاثة مستويات :"
                    +"\n"
                    +"\n"
                    +"\n"
                    +"الإعدادات:"
    )
            , mainScreen.arbicFontStyle.getLabelStyleASmall());
    Image boxvrai = new Image(Assets.boxtrue);
    Image boxfulse = new Image(Assets.boxfalse);
    Image boxmalplace = new Image(Assets.boxmalplace);
    Label Ladelvrai = new Label(mainScreen.arFont.getText(" الحرف في موضع صحيح "),mainScreen.arbicFontStyle.getLabelStyleASmall(Color.ORANGE));
    Label Ladelfulse = new Label(mainScreen.arFont.getText(" الحرف غير موجود "),mainScreen.arbicFontStyle.getLabelStyleASmall(Color.RED));
    Label Ladelmallplace = new Label(mainScreen.arFont.getText(" الحرف موجود في موضع خطأ "),mainScreen.arbicFontStyle.getLabelStyleASmall(Color.MAROON));
    

    Label info2 = new Label(mainScreen.arFont.getText(
                    "\n"
                    +" و تحتسب محاولة خاطئة ولو كان بها احرف صحيحة "
                    +"\n"
                    +" لا تحتسب الكلمة التي لا اتنتمي الى الغة العربية"
                    +"\n"
                    +"\n"
                    +" ملاحطة هامة:"
    ), mainScreen.arbicFontStyle.getLabelStyleASmall(Color.FOREST));
    Label info3  = new Label(mainScreen.arFont.getText(
                     "\n"
                    +" تعريف اللعبة "
                    +"\n"
    ), mainScreen.arbicFontStyle.getLabelStyleA(Color.BLUE));
    
    Label info4 = new Label(mainScreen.arFont.getText(
            ""
    		+"\n"
    		+" كمشروع لتخرج "
    		+"\n"
    		+" من اجل نيل الاجازة "
            +"\n"
            +" ابراهيم كلزيم "
            +"\n"
            +"   تحت اشراف  الاستاذ :  "
            +"\n"
            +" أحسين الحسين  و جمال امشارط "
            +"\n"
            +" انجزها كل من : "
            +"\n"
            +" كلمتي "
), mainScreen.arbicFontStyle.getLabelStyleASmall(Color.BLACK));

    Label info5  = new Label(mainScreen.arFont.getText(
           " لتبليغ عن كلمة غير موجودة"
    	   +"\n"
           +" للاتصال و الاتفسار  "
), mainScreen.arbicFontStyle.getLabelStyleASmall(Color.BLUE));

    
    public Tablehelp(){
        info1.setAlignment(Align.center);
        info2.setAlignment(Align.center);
        info3.setAlignment(Align.center);
        info4.setAlignment(Align.center);
        info5.setAlignment(Align.center);
        info5.addCaptureListener(new ClickListener() {
        	@Override
        	public void clicked(InputEvent event, float x, float y) {
                Gdx.net.openURI("mailto:jamalamchart@gmail.com?subject=jeux+Kalimaty&cc=ohssin1998@gmail.com");
        	}
        });
        Ladelvrai.setAlignment(Align.right);
        Ladelfulse.setAlignment(Align.right);
        Ladelmallplace.setAlignment(Align.right);
        columnDefaults(0).center();
        columnDefaults(1).right().padRight(70);
        row();
        add(info1).colspan(2);
        row();
        add(boxvrai).width(60).height(60);
        add(Ladelvrai);
        row();
        add(boxmalplace).width(60).height(60);
        add(Ladelmallplace);
        row();
        add(boxfulse).width(60).height(60);
        add(Ladelfulse);
        row();
        add(info2).colspan(2);
        row();
        add(info3).colspan(2);
        row();
        add(info4).colspan(2);
        row();
        add(info5).colspan(2);
        pack();
    }
}
}
