package Controller;

import Model.Enemy;
import Model.Player;
import View.Road;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class RoadAction {
    private static final int WIN_S = 80000;

    private Road road;
    private List<Enemy> enemies;
    private Player player;

    Timer mainTimer;

    public RoadAction(Road road, List<Enemy> enemies, Player player){
        this.road = road;
        this.enemies = enemies;
        this.player = player;
        this.mainTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move();
                Iterator<Enemy> i = enemies.iterator();
                while (i.hasNext()){
                    Enemy en = i.next();
                    en.move();
                }
                road.repaint();
                testCollision();
                testWin();
            }
        });
    }

    public Timer getTimer(){
        return mainTimer;
    }

    private void testWin() {
        if(player.s > WIN_S){
            JOptionPane.showMessageDialog(null,"Win");
            System.exit(0);
        }
    }

    private void testCollision() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if(player.getContour().intersects(e.getContour())){
                i.remove();
//                JOptionPane.showMessageDialog(null, "you lose!");
//                System.exit(1);
            }
        }
    }
}
