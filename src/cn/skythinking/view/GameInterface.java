package cn.skythinking.view;

import cn.skythinking.entity.Surround;

import javax.swing.*;
import java.awt.*;

public class GameInterface extends JFrame {

    public GameInterface(){
        this.setTitle("模拟游戏");
        this.setSize(Surround.GAME_WIDTH,Surround.GAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      //  this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Surround surround = new Surround();
        surround.draw(g);

    }
}
