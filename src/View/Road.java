package View;

import Controller.MyThread;
import Model.Enemy;
import Model.Player;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Road extends JPanel implements ActionListener{
    private static final int WIN_S = 80000;
    private ImageIcon roadIcon = new ImageIcon("img/carRoad1.png");
    private Image road = roadIcon.getImage();
    private int height = roadIcon.getIconHeight(),
            width = roadIcon.getIconWidth();
    Timer mainTimer = new Timer(20,this); // каждые 20 мс выполняется actionPerformed данного объекта
    public Player p = new Player();

    List<Enemy> enemies = new ArrayList<Enemy>();
    Thread enemiesFactory = new MyThread(this,enemies,width,height);

    public Road(){
        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }


    //попробовать в контроллер
    private class MyKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g){
        ((Graphics2D) g).drawImage(road,p.road1,0,null);
        ((Graphics2D) g).drawImage(road,p.road2,0,null);
        ((Graphics2D) g).drawImage(p.plCar,p.x,p.y,null);

        double v = (200*p.v)/Player.MAX_V; // пусть 200 км/ч - максимальная скорость
        g.setColor(Color.WHITE);
        Font speedFont =  new Font("Arial", Font.ITALIC, 20);
        g.setFont(speedFont);
        ((Graphics2D) g).drawString("Speed: " + v +" km/h",100,30);

        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if(e.x <= -width*2 || e.x > width*1.5) {
                i.remove();
            }
            else{
                ((Graphics2D) g).drawImage(e.enemCar,e.x,e.y,null);
            }
        }
    }

    //убрать implements и попробовать засунуть в контроллер
    // таймер работает по этому методу
    public void actionPerformed(ActionEvent e){
        p.move();
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy en = i.next();
            en.move();
        }
        repaint();
        testCollision();
        testWin();
    }

    private void testWin() {
        if(p.s > WIN_S){
            JOptionPane.showMessageDialog(null,"Win");
            System.exit(0);
        }
    }

    private void testCollision() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if(p.getContour().intersects(e.getContour())){
                i.remove();
//                JOptionPane.showMessageDialog(null, "you lose!");
//                System.exit(1);
            }
        }
    }
}
