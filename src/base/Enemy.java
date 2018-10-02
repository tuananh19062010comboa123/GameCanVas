package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {

    public Enemy() {
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
      this.position = new Vector2D();
    }

    @Override
    public void run() {
        //this.position.y += 2;
    }
}
