package cn.skythinking.entity;

import java.awt.*;

public class Liquid {

    private double preValue ;
    private double width ;
    private double height;
    private int x;
    private int y;
    private Color color;

    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
    public double getPreValue(){
        return this.preValue;
    }

    public Liquid(double _preValue,double _width, double _height,int x,int y,Color color){
        this.preValue = _preValue;
        this.width = _width;
        this.height = _height;
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,(int)width,(int)height);
    }





}
