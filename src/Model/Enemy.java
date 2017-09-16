package Model;


import View.Road;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    ImageIcon enemy = new ImageIcon("img/car5to.png");
    public Image enemCar = enemy.getImage();
    private int height = enemy.getIconHeight(),
            width = enemy.getIconWidth();
    public int v = 0;
    public int x, y;


    private Road road;

    // дублирование кода с Player
    public Rectangle getContour(){
        return new Rectangle(x,y,width,height);
    }

    public Enemy(int x, int y, int v, Road road){
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }


    public void move(){
        x = x - road.p.v + v;
    }
}
