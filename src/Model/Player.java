package Model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static final int MAX_V = 90;
    private static final int MAX_TOP = 45;
    private static final int MAX_BOTTOM = 575;

    private ImageIcon player = new ImageIcon("img/car3.png");
    private Image plCar_c = player.getImage();
    private Image plCar_u = new ImageIcon("img/car3up.png").getImage();
    private Image plCar_d = new ImageIcon("img/car3down.png").getImage();

    public Image plCar = plCar_c;

    private int height = player.getIconHeight(),
            width = player.getIconWidth();

    public int v = 0,
        a = 0,
        s = 0;
    public int health = 100;
    public int road1 = 0,
        road2 = 1700;   // ширина картинки
    public int x = 50, y = 70;
    // -------------
    private int dy = 0;

    // дублирование кода с Enemy
    public Rectangle getContour(){
        return new Rectangle(x,y+10,width,height-20);
    }


    public void move() {
        s += v;
        v += a;
        if(v <=0) v = 0;
        if(v>=MAX_V) v = MAX_V;
        y -=dy;
        if(y<=MAX_TOP) y = MAX_TOP;
        if(y>=MAX_BOTTOM) y = MAX_BOTTOM;
        if (road2 - v <= 0) {
            road1 = road2 - v;  // дабы не было непонятных резких сдвигов дороги
            road2 = road1 + 1700;
        }
        else {
            road1 -= v;
            road2 -= v;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        // d - 68; w - 87; s - 83; a - 65
        if(key == 68 || key == KeyEvent.VK_RIGHT){
            a = 3;
        }
        if(key == 65 || key == KeyEvent.VK_LEFT){
            a = -3;
        }
        if(key == 87 || key == KeyEvent.VK_UP){
            dy = 4;
            plCar = plCar_u;
        }
        if(key == 83 || key == KeyEvent.VK_DOWN){
            dy = -4;
            plCar = plCar_d;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        // d - 68; w - 87; s - 83; a - 65
        if(key == 68 || key == KeyEvent.VK_RIGHT ||
                key == 65 || key == KeyEvent.VK_LEFT){
            a = 0;
        }
        if(key == 87 || key == KeyEvent.VK_UP ||
                key == 83 || key == KeyEvent.VK_DOWN){
            dy = 0;
            plCar = plCar_c;
        }

    }

}
