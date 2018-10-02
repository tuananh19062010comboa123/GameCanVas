package base;

import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class PlayerBullet extends GameObject {
   /* Renderer renderer ;
    Vector2D position;*/
   /*private  ArrayList<PlayerBullet> playerBullets;*/
  /*  private int check;*/
   ArrayList<BufferedImage> image;
   int count ;
    public PlayerBullet(){
        ArrayList<BufferedImage> image = new ArrayList<>();

        image.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        image.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        image.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        image.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        image.add(SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"));
        image.add(SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"));
        image.add(SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"));
        image.add(SpriteUtils.loadImage("assets/images/sphere-bullets/3.png"));
        this.renderer = new AnimationRenderer(image);
      /*  ArrayList<BufferedImage> images = SpriteUtils.loadImages("assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png");

        this.renderer = new AnimationRenderer(images);*/
      //  this.position = new Vector2D(Settings.position_PLAYER_Bullet_X,Settings.position_PLAYER_Bullet_Y);
       this.position = new Vector2D(0,0);
     }



    @Override
    public void run() {


             /*this.position.x -= 5;*/
             this.position.y -= 5;
            /*
              Player.bullet.position.y -= 5;
             Player.bulletTest.position.x += 2;
             Player.bulletTest.position.y -= 2;*/



           /* playerBullets.get(i).position.x += 0;
            playerBullets.get(i).position.y -= 7;

            playerBullets.get(1).position.x += 5;
            playerBullets.get(1).position.y -= 2;
*/


            /*Player.bulletTest.position.x += 2;
            Player.bulletTest.position.x -= 7;
*/

           /* this.position.x += 2;
            this.position.y -= 7;
            return;
*/
       /* this.position.x += 2;*/
       /* this.position.y -= 7;*/
    }
}
