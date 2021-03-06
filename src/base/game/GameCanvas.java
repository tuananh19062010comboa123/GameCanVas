package base.game;

import base.*;
import base.enemy.Enemy;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
   /* BufferedImage background;
    int backgroundY = 0;
    BufferedImage player;

    public GameCanvas(){
        this.background = SpriteUtils.loadImage("assets/images/background/0.png");
        this.player = SpriteUtils.loadImage("assets/images/players/straight/0.png");
    }

    @Override
    public void paintComponent(Graphics g) {
       // super.paintComponents(g);
        g.drawImage(background,0,backgroundY,null);
        g.drawImage(player,200,300,null);
        backgroundY = backgroundY - 1;
    }*/
   Background background;
   Player player;
   Enemy enemy;
   EnemySummoner enemySummoner ;
   /*public static ArrayList<Enemy> enemies ;
    public static ArrayList<PlayerBullet> playerBullets ;*/

    int backgroundY = 0;
   /* BufferedImage player;*/

   /* public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        enemies = new ArrayList<>();
         for (int i = 0; i < 5; i ++) {
             enemy = new Enemy();
             enemy.position = new Vector2D(i*90,0);
             enemies.add(enemy);
        }
        playerBullets = new ArrayList<>();
    }*/
   public GameCanvas(){
       this.background = GameObject.recycle(Background.class);
        //((SingleImageRenderer) this.background.renderer).image
        //((AnimationRenderer) bullet.renderer).images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"))
        /* this.player = new Player();
       enemies = new ArrayList<>();
       for (int i = 0; i < 5; i ++) {
           enemy = new Enemy();
           enemy.position = new Vector2D(i*90,0);
           enemies.add(enemy);
       }
       playerBullets = new ArrayList<>();*/
       /*for(int i = 0 ; i< 2;i++){
           Enemy enemy = GameObject.recycle(Enemy.class);
           enemy.position = new Vector2D(i*90+150,50);
       }*/


       this.enemySummoner = GameObject.recycle(EnemySummoner.class);

     //  this.enemy = GameObject.recycle(Enemy.class);



       this.player = GameObject.recycle(Player.class);


   }

    /*public void run(){
        background.run();
        player.run();
        for(Enemy enemy : enemies){
            enemy.run();
        }
        for(PlayerBullet playerBullet : playerBullets){
            playerBullet.run();
        }

    }*/

    public void run(){
        GameObject.runAll();

    }

   /* public  void render(Graphics g){
        // super.paintComponents(g);
        background.render(g);
        player.render(g);
        for(Enemy enemy : enemies){
            enemy.render(g);
        }
        for(PlayerBullet playerBullet : playerBullets){
            playerBullet.render(g);
        }


    }*/
   public  void render(Graphics g){
      GameObject.renderAll(g);
   }

    @Override
    public void paintComponent(Graphics g) {
        this.render(g);

    }
}
