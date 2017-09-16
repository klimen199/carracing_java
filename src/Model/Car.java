package Model;


import javax.swing.*;
import java.awt.*;

public class Car {
    public ImageIcon imgIcon;
    public int v;
    public int x, y;
    public int width, height;

    public Rectangle getContour() {
        return new Rectangle(x, y, width, height);
    }
}
