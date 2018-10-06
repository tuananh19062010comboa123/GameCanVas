package base;

import base.counter.FrameCount;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static base.Enemy.countBullet;

public class EnemyBullet extends GameObject implements Physics{
    Vector2D velocity ;
    BoxCollider collider;

    public EnemyBullet(){
        super();
        ArrayList<BufferedImage> image = new ArrayList<>();
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/white.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        this.renderer = new AnimationRenderer(image);
        this.position = new Vector2D(0,0);
        this.velocity = new Vector2D(0,0);
        this.collider = new BoxCollider(16,16);

    }

    @Override
    public void run() {

        Player player = GameObject.intersect(Player.class,this);
        if(player != null){
            this.destroy();
            Enemy.countBullet++;
            if(Enemy.countBullet == 5) {
                player.destroy();
            }
            return;

            /* if( Enemy.receiveBullet.run()){
                player.destroy();
            }*/

         /*   player.destroy();
            this.destroy();
            return;*/
        }

        if(this.position.y > Settings.SCREEN_HEIGHT ){
            this.destroy();
            return;
        }
        this.position.y += 1;
        this.position.addThis(velocity.x,velocity.y);// cái quyết định để đổi hướng
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
