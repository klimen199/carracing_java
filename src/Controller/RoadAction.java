package Controller;

import Model.Enemy;
import Model.Player;
import View.Road;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class RoadAction implements ActionListener{
    private Road road;
    private List<Enemy> enemies;
    private Player player;

    Timer mainTimer = new Timer(20,this); // каждые 20 мс выполняется actionPerformed данного объекта

    public RoadAction(Road road, List<Enemy> enemies, Player player){
        this.road = road;
        this.enemies = enemies;
        this.player = player;
    }

    public void actionPerformed(ActionEvent e){
        player.move();
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy en = i.next();
            en.move();
        }
//        repaint();
//        testCollision();
//        testWin();
    }

}
