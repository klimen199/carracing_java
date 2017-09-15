package View;

import Controller.MyThread;
import Controller.PlayerKeyAdapter;
import Controller.RoadAction;
import Model.Enemy;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Road extends JPanel {
    private ImageIcon roadIcon = new ImageIcon("img/carRoad1.png");
    private Image road = roadIcon.getImage();
    private int height = roadIcon.getIconHeight(),
            width = roadIcon.getIconWidth();
    public Player p = new Player();

    private List<Enemy> enemies = new ArrayList<Enemy>();
    private MyThread enemiesFactory = new MyThread(this,enemies,width,height);
    private RoadAction roadAction = new RoadAction(this,enemies,p);

    public Road(){
        roadAction.getTimer().start();
        enemiesFactory.start();
        addKeyListener(new PlayerKeyAdapter(p));
        setFocusable(true);
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


}
