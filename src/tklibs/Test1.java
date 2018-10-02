package tklibs;

public class Test1 {
    // thuoc tinh
    public  int count ;

    //contructor - ham tao
    public Test1(){
        this.count = 0;
    }
    public  Test1(int count){
        this.count = count;
    }

    //method
   public void pluss(int x){
    count = count + x;
    }

    public void  print(){
        System.out.println(" gia tri cua count" + count);
    }


}
