package Controller;


import Model.Enemy;
import View.Road;

import java.util.List;
import java.util.Random;

public class MyThread extends Thread {
    private Road road;
    private List<Enemy> enemies;
    private int roadWidth;
    private int roadHeight;
    int roadBandHeight;


    public MyThread(Road road, List<Enemy> enemies, int width, int height){
        this.road = road;
        this.enemies = enemies;
        this.roadWidth = width;
        this.roadHeight = height;
        roadBandHeight = (int)((height-120)/4);
    }

    @Override
    public void run() {

        while (true){
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                enemies.add(new Enemy(roadWidth+rand.nextInt(400),
                        roadBandHeight*3+65,
                        rand.nextInt(30)+30,
                        road));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
