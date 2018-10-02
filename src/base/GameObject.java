package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();// add thang moi



    //  public static  <E> E create(Class<E> childClass) , < E > <->  Class E = new Class()
    public static  <E extends GameObject> E create(Class<E> childClass) {
        //Class E = new Class(GameObject)
        try {
            GameObject newGameObject = childClass.newInstance();// ???? childClass is Object or Class
            newGameObjects.add(newGameObject);// add vao list moi
            return (E)newGameObject;
        }catch (Exception e){
            return null;
        }

    }

    /**
     * duyet ArrayList de cac doi tuong run run and run
     */
    public static void runAll(){
        /*for( GameObject go : gameObjects){
            go.run();
        }*/
        for(int i = 0  ; i< gameObjects.size();i++){
                gameObjects.get(i).run();
        }

    }

    public static void  renderAll(Graphics g){
        for(GameObject go : gameObjects){
            go.render(g);
        }
        gameObjects.addAll(newGameObjects);
        gameObjects.size();
        newGameObjects.clear();
    }


    BufferedImage image;
    Renderer renderer ;
    public Vector2D position;

    public GameObject(){

    }

    public  GameObject(BufferedImage image){
        this.image = image;
        this.position = new Vector2D(0,0);
    }

    public void run(){

    }

    public  void render(Graphics g){
        if(this.renderer != null){
            this.renderer.render(g,this);

        }

        //g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }
}
