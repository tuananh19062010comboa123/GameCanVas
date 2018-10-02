package base;

import tklibs.Mathx;

public class Vector2D {
   public float x ;
   public float y ;
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    /**
     *
     * @param x
     * @param y
     */
    public Vector2D(float x, float y) {
            this.x = x;
            this.y = y;
    }

    /**
     *
     * @return an other vector with same x & y
     */
    public Vector2D clone(){
        Vector2D clone = new Vector2D(this.x,this.y);
        return clone;
    }

    /**
     *
     * @param x
     * @param y
     * @return ko thay doi vector goc
     */

    public Vector2D add(float x , float y){
        Vector2D result = new Vector2D(this.x + x,this.y + y);
        return result;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Vector2D addThis(float x , float y){
        this.x += x;
        this.y += y;
        return  this;
    }
    public Vector2D set(float x ,float y){
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     *
     * @param x
     * @param y
     * @return result
     */
    public Vector2D substract(float x , float y){
        Vector2D result = new Vector2D(this.x - x,this.y - y);
        return result;
    }


    public Vector2D substractThis(float x , float y){
        this.x -= x;
        this.y -= y;
        return  this;
    }

    public Vector2D scale(float n){
        Vector2D result = new Vector2D(this.x * n,this.y * n);
        return result;
    }

    public Vector2D scaleThis(float n){
        this.x *= n;
        this.y *= n;
        return  this;
    }

    public float length(){
        return (float) Math.sqrt(x * x + y * y);
    }

    public  void print(){ System.out.println(x + "; " + y);
    }

    @Override
    public String toString() {
        return "(x : " + x + ", y " + y + ")";
    }

    /*public  static void main(String[] argv){
        Vector2D v1 = new Vector2D(1,1);
        System.out.println(v1);
    }*/
}
