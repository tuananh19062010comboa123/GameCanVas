package base;

import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    //Renderer  renderer; da co tu GameObject
   public static int countBackground;
   public static int countDelayMoveMap;
    public Background(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
       // this.image = image;
        this.renderer = new SingleImageRenderer(image);// trong  GameObject co thuco tinh Renderer
        //  ???  tao moi SingleImageRenderer la doi tuong Renderer
        this.position = new Vector2D(0,-(image.getHeight() - Settings.SCREEN_HEIGHT));
        //assets/images/scenes/game-over-background.jpg
    }

    @Override
    public void run() {

         if(this.position.y >= 0) {
             countDelayMoveMap++;
             if(countBackground == 5){// cu 70 fram enemySummoner moi sinh ra 1 luot enemy
                 return;               // dam bao khi background cham day la enemySummon ngung ban
             }
             countBackground++;
                   /* return;*/
         }else {
             this.position.y += 5;
         }
    }
}
