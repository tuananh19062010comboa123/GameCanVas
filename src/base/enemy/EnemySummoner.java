package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.physic.BoxCollider;
import base.physic.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemySummoner extends GameObject implements Physics {
    BoxCollider collider;
    Vector2D velocity ;
    Action action;

    public EnemySummoner(){
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new AnimationRenderer(images);
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
        ActionWait actionWait = new ActionWait(70);
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
        //this.action = actionWait;
    }

    @Override
    public void run() {
        this.action.run(this);
    }

    public void shoot (){
        Enemy enemy1 = GameObject.recycle(Enemy.class);
        Enemy enemy2 = GameObject.recycle(Enemy.class);
        Enemy enemy3 = GameObject.recycle(Enemy.class);
        Enemy enemy4 = GameObject.recycle(Enemy.class);
        Enemy enemy5 = GameObject.recycle(Enemy.class);
        Enemy enemy6 = GameObject.recycle(Enemy.class);
        Enemy enemy7 = GameObject.recycle(Enemy.class);
        Enemy enemy8 = GameObject.recycle(Enemy.class);


        enemy1.velocity.set(0,-3);
        enemy2.velocity.set(-1,-3);
        enemy3.velocity.set(1,-3);
        enemy4.velocity.set(-1,-3);
        enemy5.velocity.set(1,-3);
        enemy6.velocity.set(-1,2);
        enemy7.velocity.set(1,2);
        enemy8.velocity.set(0,2);

        enemy1.position.set(this.position.x,this.position.y-50);
        enemy2.position.set(this.position.x-50,this.position.y-100);
        enemy3.position.set(this.position.x+50,this.position.y-100);
        enemy4.position.set(this.position.x-100,this.position.y-50);
        enemy5.position.set(this.position.x+100,this.position.y-50);
        enemy6.position.set(this.position.x-50,this.position.y+50);
        enemy7.position.set(this.position.x+50,this.position.y+50);
        enemy8.position.set(this.position.x,this.position.y+100);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
