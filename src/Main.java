import View.Road;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("My game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550,800);
        frame.setLocationRelativeTo(null);

        frame.add(new Road());
        frame.setVisible(true);
    }
}
