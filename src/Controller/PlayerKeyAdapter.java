package Controller;


import Model.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerKeyAdapter extends KeyAdapter {
    Player player;

    public PlayerKeyAdapter(Player p){
        this.player = p;
    }

    public void keyPressed(KeyEvent e){
        player.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        player.keyReleased(e);
    }
}
