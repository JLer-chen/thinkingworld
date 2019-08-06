package cn.skythinking.entity;

import cn.skythinking.util.RandomUtil;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Person {
    private Surround surround;
    private String name;
    private int bodyHeight;
    private int bodyWidth;
    private int headWidth;
    private int headHeight;
    private int footPositionX;
    private int footPositionY;
    private Color bodyColor;
    private Color headColor;
    private int speed;
    private int hungerValue = 100;
    private int hungerValueDelete = 9;
    private int thirstValue = 100;
    private int thirstValueDelete = 7;
    private boolean wantEat ;
    private boolean wantDrink;
    private static final Random random = new Random();
    private double viewRadius ;


    public Person(Surround surround, String name, int bodyHeight, int bodyWidth,
                  int headWidth, int headHeight, int footPositionX, int footPositionY,double viewRadius) {
        this.surround = surround;
        System.out.println(String.format("%s诞生了，它来到了这个世界", name));
        this.bodyColor = Color.ORANGE;
        this.headColor = Color.PINK;
        this.name = name;
        this.speed = 10;
        this.bodyHeight = bodyHeight;
        this.bodyWidth = bodyWidth;
        this.headWidth = headWidth;
        this.headHeight = headHeight;
        this.footPositionX = footPositionX;
        this.footPositionY = footPositionY;
        this.wantDrink = false;
        this.wantEat = false;
        this.viewRadius = viewRadius;
    }
    private void metroMetabolism(){
        System.out.println(String.format("metroMetabolism hunger:%d,thirstValue:%d", hungerValue,thirstValue));
        this.hungerValue -= RandomUtil.randomInt(0,this.hungerValueDelete);
        this.thirstValue -= RandomUtil.randomInt(0,this.thirstValueDelete);
        this.hungerValue = this.hungerValue <= 0 ? 0 : this.hungerValue;
        this.thirstValue = this.thirstValue <= 0 ? 0 : this.thirstValue;
    }

    private void drink(Liquid liquid){
        this.thirstValue += liquid.getHeight()*liquid.getWidth()*liquid.getPreValue();

    }


    private Liquid getCanLookLiquidFromSurround(Surround surround){
        List<Liquid> liquids = surround.getLiquid();
        for(int i  =  0 ; i < liquids.size(); i++ ) {
            Liquid liquid = liquids.get(i);


        }

        return null;
    }

    public void doInSomeThing(){
        if(wantDrink && getCanLookLiquidFromSurround(surround) != null ){

           //  drink()

        }else if(wantEat){
            //TODO
        }else{
            randomMove();
        }
    }

    private void drawView(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval((int)(footPositionX-2*viewRadius),(int) (footPositionY-bodyHeight-headHeight-viewRadius), (int)(viewRadius*4) , (int)(viewRadius*2));
    }


    public void move(int x, int y) {
        System.out.println(String.format("move x:%d,y:%d", x, y));
        this.footPositionX += x;
        this.footPositionY += y;
        if (footPositionX > footPositionXLimitMax()) footPositionX = footPositionXLimitMax();
        if (footPositionX < footPositionXLimitMin()) footPositionX = footPositionXLimitMin();
        if (footPositionY > footPositionYLimitMax()) footPositionY = footPositionYLimitMax();
        if (footPositionY < footPositionXLimitMin()) footPositionY = footPositionYLimitMin();
        this.metroMetabolism();
    }

    public void randomMove() {
        move(RandomUtil.randomInt(-speed,speed), RandomUtil.randomInt(-speed,speed));
    }

    public void draw(Graphics g) {
        drawBody(g);
        drawHead(g);
        drawView(g);
    }

    private void drawHead(Graphics g) {
        g.setColor(headColor);
        g.fillOval(footPositionX - (headWidth >> 1), footPositionY - bodyHeight - headHeight, headWidth, headHeight);
    }

    private void drawBody(Graphics g) {
        g.setColor(bodyColor);
        g.fillOval(footPositionX - (bodyWidth >> 1), footPositionY - bodyHeight, bodyWidth, bodyHeight);
    }


    private int footPositionYLimitMin() {
        return headHeight + bodyHeight;
    }

    private int footPositionYLimitMax() {
        return Surround.GAME_HEIGHT;
    }

    private int footPositionXLimitMax() {
        return Surround.GAME_WIDTH - (bodyWidth >> 1) < Surround.GAME_WIDTH - (headWidth >> 1) ?
                Surround.GAME_WIDTH - (bodyWidth >> 1) : Surround.GAME_WIDTH - (headWidth >> 1);
    }

    private int footPositionXLimitMin() {
        return (bodyWidth >> 1) > +(headWidth >> 1) ?
                (bodyWidth >> 1) : +(headWidth >> 1);
    }


}
