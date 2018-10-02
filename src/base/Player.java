package base;

import base.counter.FrameCount;
import base.game.GameCanvas;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import sun.java2d.pipe.SpanClipRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

public class Player extends GameObject{
   // public static ArrayList<PlayerBullet> listPlayerBullets;

    /*public static PlayerBullet bullet;
    public static PlayerBullet bulletTest;*/
    FrameCount shootCount;
    int count = 0;
    public Player(){
       /* BufferedImage imagePlayer = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.image = imagePlayer;*/
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));

       /* ArrayList<BufferedImage> images = SpriteUtils.loadImages("assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png","assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png","assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png","assets/images/players/straight/6.png");*/
        this.renderer = new AnimationRenderer(images);

       // this.renderer = new SingleImageRenderer("assets/images/players/straight/0.png");
        this.position = new Vector2D(Settings.Start_PLAYER_POSITION_X,Settings.Start_PLAYER_POSITION_y);
        this.shootCount = new FrameCount(10);
    }


    @Override
    public void run() {
       if(KeyEventPress.isUpPress){
           this.move(0,-1);
       } if(KeyEventPress.isDownpPress){
            this.move(0,+1);
       } if(KeyEventPress.isLeftPress) {
           this.move(-1, 0);
       } if(KeyEventPress.isRightPress) {
           this.move(+1, 0);
       }
       boolean fireCounterRun  = this.shootCount.run();
        if(KeyEventPress.isSpace && fireCounterRun){
            this.shoot();
        }

    }

    public void move(int translatex , int translatey){
        this.position.addThis(translatex,translatey);
    }

    void  shoot(){
       /*if(this.shootCount.run()){
           PlayerBullet bullet = new PlayerBullet();
           GameCanvas.playerBullets.add(bullet);
           bullet.position.set(this.position.x,this.position.y);
           this.shootCount.reset();
       }*/

        if(this.shootCount.run()){
          //  ((AnimationRenderer) bulletOne.renderer).images.get(1) lay anh
                    PlayerBullet  bulletOne = GameObject.create(PlayerBullet.class);
                    bulletOne.position.set(this.position.x-20,this.position.y);// dand de ham set ahihi

                    /*((AnimationRenderer) bullet.renderer).images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/0.png"));
                    ((AnimationRenderer) bullet.renderer).images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/1.png"));
                    ((AnimationRenderer) bullet.renderer).images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/2.png"));
                    ((AnimationRenderer) bullet.renderer).images.add(SpriteUtils.loadImage("assets/images/sphere-bullets/3.png"));*/

                    PlayerBullet  bullet = GameObject.create(PlayerBullet.class);
                    for(int i = 0 ; i< ((AnimationRenderer) bullet.renderer).images.size();i++) {
                        ((AnimationRenderer) bullet.renderer).images.get(i);
                        if (i < 4) {
                            ((AnimationRenderer) bullet.renderer).images.remove(0);
                        }
                    }
                    bullet.position = new Vector2D(this.position.x,this.position.y);

                    PlayerBullet  bulletTest = GameObject.create(PlayerBullet.class);
                    bulletTest.position = new Vector2D(this.position.x+20,this.position.y);

                     this.shootCount.reset();

                    /* PlayerBullet playerBullet2 = GameObject.create(PlayerBullet.class);*/


            /*  PlayerBullet bullet = GameObject.create(PlayerBullet.class);
              bullet.position.set(this.position.x,this.position.y);

              bulletTest = GameObject.create(PlayerBullet.class);
              bulletTest.position.set(200,this.position.y);
            *//*  listPlayerBullets.add(bullet);*//*
              this.shootCount.reset();
*/
           /* PlayerBullet bullet = GameObject.create(PlayerBullet.class);
            bullet.position.set(this.position.x,this.position.y);
            this.shootCount.reset();*/
        }
    }
}


