package base.game;

import base.KeyEventPress;
import base.game.GameCanvas;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    //JFram dai dien cho 1 cai cua so
    //BufferedImage background;
    GameCanvas gameCanvas;
    public static int heightOfGamewindow;


    public GameWindow(){
        //setup window
        // this tro vao doi tuong khoi tao
        this.setVisible(true); // show man hinh
        this.setSize(650,700);
      /*  int x = this.getSize().width;*/
        heightOfGamewindow = this.getSize().height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// song chuong trinh ki tat cua so window
        this.setupEventListtener();
        //init game
       // this.loadImageoWindow();

        /* khoi tao gameCanvas*/
         this.gameCanvas = new GameCanvas();


        this.add(gameCanvas);// ????
        this.setResizable(false);// ko cho reSize
    }

    private void setupEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                } if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownpPress = true;
                } if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                } if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                } if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isSpace = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                } if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownpPress = false;
                } if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                } if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                } if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isSpace = false;
                }
            }
        });
    }

    /* void loadImageoWindow(){
         //  BufferedImage : class image in java
       *//*  BufferedImage background =  SpriteUtils.loadImage("assets/images/background/0.png");*//*
            this.background = SpriteUtils.loadImage("assets/images/background/0.png");
            // this vi da khai bao Object BufferedImage o tren
    }

    @Override
    public void paintComponents(Graphics g) {
        if(this.background != null){

        }

    }*/
    public void gameLoop(){
        long delay = 1000 / 60;
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if( currentTime - lastTime > delay ){
                gameCanvas.run();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
