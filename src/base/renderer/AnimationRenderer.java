package base.renderer;

import base.GameObject;
import base.counter.FrameCount;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer{
    public  ArrayList<BufferedImage> images;
    int currentImage = 0;
   // int frameCount = 0;
    FrameCount frameCount;


    /*public AnimationRenderer(ArrayList<BufferedImage> images){
        this.images = images;
    }*/

    public AnimationRenderer(ArrayList<BufferedImage> images){
        this.images = images;
        this.frameCount = new FrameCount(5);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images,int frameCount){
        this.images = images;
        this.frameCount = new FrameCount(frameCount);
    }

  /*  @Override
    public void render(Graphics g, GameObject master) {
        if(images.size() > 0) {
            g.drawImage(images.get(currentImage),(int)master.position.x, (int)master.position.y,null );

            if(frameCount > 5){// thang anh 1 chay 5 lan rui moi toi thang thu 2
                currentImage ++;
                if(currentImage >= images.size() - 1){
                    currentImage = 0;
                }
                frameCount = 0;
            }else {
                frameCount++;
            }

        }
    }*/
  @Override
  public void render(Graphics g, GameObject master) {
      if(images.size() > 0) {
          g.drawImage(images.get(currentImage),(int)master.position.x, (int)master.position.y,null );

          if(this.frameCount.run()){// thang anh 1 chay 5 lan rui moi toi thang thu 2
              currentImage ++;
              if(currentImage >= images.size() - 1){
                  currentImage = 0;
              }
              this.frameCount.reset();
          }

      }
  }
}
