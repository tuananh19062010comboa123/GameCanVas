package base;

import base.counter.FrameCount;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    FrameCount shootCountEnemy;
    public static int countBullet ;
  /*  public static FrameCount receiveBullet;*/
    public Enemy() {
        super();
        ArrayList<BufferedImage>  images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
        this.renderer = new AnimationRenderer(images);

        // hien tai bao loi cach dung loadImages nen dung lai cach cu

        /*ArrayList<BufferedImage> images = SpriteUtils.loadImages("assets/images/enemies/level0/black/0.png",
              "assets/images/enemies/level0/black/1.png",
              "assets/images/enemies/level0/black/2.png",
              "assets/images/enemies/level0/black/3.png",
              "assets/images/enemies/level0/black/4.png",
              "assets/images/enemies/level0/black/5.png",
              "assets/images/enemies/level0/black/6.png",
              "assets/images/enemies/level0/black/7.png",
              "assets/images/enemies/level0/black/8.png");
      this.renderer = new AnimationRenderer(images);*/
      this.position = new Vector2D(200,100);
      this.collider = new BoxCollider(28,28);
      this.shootCountEnemy = new FrameCount(15);// nhanh hay chậm quyết định ở đây !!!
        /*this.receiveBullet = new FrameCount(3);*/
    }

    @Override
    public void run() {
        //this.position.y += 2;
        if(this.shootCountEnemy.run()){
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            EnemyBullet enemyBullet2 = GameObject.recycle(EnemyBullet.class);
            EnemyBullet enemyBullet3 = GameObject.recycle(EnemyBullet.class);

           // enemyBullet.velocity.set(0,1);
            enemyBullet.velocity.set(0,1);
            enemyBullet2.velocity.set(-2,1);
            enemyBullet3.velocity.set(+2,1);
            enemyBullet.position.set(this.position.x,this.position.y);
            enemyBullet2.position.set(this.position.x,this.position.y);
            enemyBullet3.position.set(this.position.x,this.position.y);
            this.shootCountEnemy.reset();
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
