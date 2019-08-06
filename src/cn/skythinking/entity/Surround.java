package cn.skythinking.entity;

import cn.skythinking.util.Time;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.util.Random;

public class Surround {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    private List<Liquid> liquidList = new ArrayList<>();
    public void drawSurround(Graphics g){
        g.clearRect(0,0,GAME_WIDTH,GAME_HEIGHT);
    }
    public void draw(Graphics g) {
        Person person = new Person(this,"小明",100,40,20,20,400,400,100);
        Liquid liquid = new Liquid(1.2, 50.3,60.6,20,30,Color.BLUE);
        liquidList.add(liquid);
        for(int i = 0 ; i < 100; i++){

            drawSurround(g);
            person.doInSomeThing();
            person.draw(g);
            liquid.draw(g);
            Time.sleep(1000);
        }
    }

    public List<Liquid> getLiquid(){
        return liquidList;
    }

}
