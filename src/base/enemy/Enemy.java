package base.enemy;

import base.*;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.counter.FrameCount;
import base.physic.BoxCollider;
import base.physic.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
  // FrameCount shootCountEnemy;
    public static int countBullet ;
    Vector2D velocity ;
    Action action;


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
      this.position = new Vector2D(200,200);
      this.velocity = new Vector2D(0,0);
      this.collider = new BoxCollider(28,28);
   //   this.shootCountEnemy = new FrameCount(15);// nhanh hay chậm quyết định ở đây !!!

        /*this.action = new Action() { //cach khai bao action truc tiep
            @Override
            public void run(GameObject master) {//chay thay the ham run o duoi
            master.position.addThis(+5,5);
            }

            @Override
            public void reset() {

            }
        };*/
        this.defineAction();

    }
    void defineAction(){
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {// neu this.shoot thi this la actionFire
            @Override
            public void run(GameObject master) {
             //   master.position.addThis(+5,30);
                shoot();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(actionWait,actionFire);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;
    }

    @Override
    public void run() {
        if(this.position.y < 0 || this.position.y > Settings.SCREEN_HEIGHT
                || this.position.x < 0 || this.position.x > Settings.SCREEN_WIDTH ){
            this.destroy();
            return;
        }
      /*  this.position.y += 1;*/
        this.position.addThis(velocity.x,velocity.y);// cái quyết định để đổi hướng

        this.action.run(this);


    }

    public void shoot (){
        EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
      /*  EnemyBullet enemyBullet2 = GameObject.recycle(EnemyBullet.class);
        EnemyBullet enemyBullet3 = GameObject.recycle(EnemyBullet.class);*/
        // enemyBullet.velocity.set(0,1);
        enemyBullet.velocity.set(0,5);
     /*   enemyBullet2.velocity.set(-2,1);
        enemyBullet3.velocity.set(+2,1);*/
        enemyBullet.position.set(this.position.x,this.position.y);
       /* enemyBullet2.position.set(this.position.x,this.position.y);
        enemyBullet3.position.set(this.position.x,this.position.y);*/

       /* if(this.shootCountEnemy.run()){
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
        }*/
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
