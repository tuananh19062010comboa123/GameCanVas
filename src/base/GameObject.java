package base;

import base.physic.Physics;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();// add thang moi


    /*public static int countBullet ;*/
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

    public static < E extends GameObject> E recycle(Class<E> childclass){
        // 1. kiem tra co gameObject thoa man yeu cau ( isActive == false && go instanceof childcass ) ko
        // co thi dung lai
        // ko co thi tao moi
        // 2. Return gameObject
        for(GameObject go : gameObjects){
            if(!go.isActive && go.getClass().isAssignableFrom(childclass)){// gameObject co thuoc class nay ko
                go.isActive = true;
                return (E) go;
            }
        }
        return create(childclass);
    }

    /**
     * kiem tra 1 Object truyen vao co va cham ko
     * Physics la thang muon kiem tra tat ca cac Object co thang nao nao va cham vs minh
     */
    public static <E extends GameObject> E intersect(Class<E> childClass, Physics physics){
       /* for(GameObject go : gameObjects){
            if(go.isActive && go.getClass().isAssignableFrom(childClass)
            && go instanceof Physics){
                Physics physicsGo = (Physics) go;    // truyền vào đây 1 thằng Physic và 1 GameObject
                boolean intersected = physics.getBoxCollider().intersect(physicsGo,(GameObject) physics);
                                    //gọi hàm  intersect(physicsGo,(GameObject) physics) phải thoogn qua getBoxCollider()
                if(intersected){// neu true <=> va cham
                 //   Enemy.countBullet++;
                    return (E) physicsGo;
                }
            }
        }
        return null;*/
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject go = gameObjects.get(i);
            if (go.isActive && go.getClass().isAssignableFrom(childClass)
                    && go instanceof Physics) {
                Physics physicsGo = (Physics) go;    // truyền vào đây 1 thằng Physic và 1 GameObject
                boolean intersected = physics.getBoxCollider().intersect(physicsGo, (GameObject) physics);
                //gọi hàm  intersect(physicsGo,(GameObject) physics) phải thoogn qua getBoxCollider()
                if (intersected) {// neu true <=> va cham
                    //   Enemy.countBullet++;
                    return (E) physicsGo;
                }
            }
        }
        return null;
    }

    /**
     * duyet ArrayList de cac doi tuong run run and run
     */
    public static void runAll(){
        /*for( GameObject go : gameObjects){
            go.run();
        }*/
        for(int i = 0  ; i< gameObjects.size();i++){
            /*gameObjects.get(i).run();*/
            GameObject go  = gameObjects.get(i);
            if(go.isActive){
                go.run();
            }

        }

    }

    public static void  renderAll(Graphics g){

        for(GameObject go : gameObjects){//for kiểu này : mỗi lần lặp lại của vòng loop trong GameWindow
            if(go.isActive){             // nếu dể thế này thì gameObjects.length van giữ độ dài của lần chạy đầu tiên
                go.render(g);            // khi mà tạo ra cá đối tượng mới ở lần chạy tiếp theo thì lengt vẫn ko đổi
            }                            // nên cần tạo một thằng newGameObjects add những thằng mới sau Đó
                                         // sau Đó  gameObjects.addAll(newGameObjects);
        }
        gameObjects.addAll(newGameObjects);
       /* gameObjects.size();*/
        newGameObjects.clear();
    }


    BufferedImage image;
    public   Renderer renderer ;
    public Vector2D position;
    public boolean isActive;// check

    public GameObject(){
        this.isActive = true;
    }

    public  GameObject(BufferedImage image){
        this.isActive = true;
        this.image = image;// chua biet co xoa ko
        this.position = new Vector2D(0,0);
    }

    public boolean destroy(){
       return this.isActive = false;
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
