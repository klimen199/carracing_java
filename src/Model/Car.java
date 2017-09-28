package Model;


import java.awt.*;

public abstract class Car {
    //    public ImageIcon imgIcon;
    public int v;
    public int x, y;
//    public int width = imgIcon.getIconWidth(),
//            height = imgIcon.getIconWidth();

    public Rectangle getContour() {
        return new Rectangle(x, y, 100, 100);
    }

    public abstract void move();
}
