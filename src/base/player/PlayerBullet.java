package base.player;

import base.physic.BoxCollider;
import base.GameObject;
import base.physic.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    Vector2D velocity;
    BoxCollider collider;
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
       this.velocity = new Vector2D(0,0);
       this.collider = new BoxCollider(24,24);
     }



    @Override
    public void run() {
        this.position.y -= 5;

        // lay ra enemy va cham
        Enemy enemy = GameObject.intersect(Enemy.class,this);
        if(enemy != null){
            // trước dòng này đối tượng khởi tạo được gán isAction = true
            enemy.destroy();  // tới đây gán  gán isAction = false <--> khi run lại trong GameLoop thì Enemy ko run
            this.destroy();// ??? để làm gì liệu có cần ko
            return;
        }

        if(this.position.y < 0){
            this.destroy();
            return;
        }

        this.position.addThis(velocity.x,velocity.y);
        //this.position.y -= 5;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
