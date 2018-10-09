package base.counter;

public class FrameCount {
    int frameCount;
    int maxCount;

    public  FrameCount(int maxCount){
        this.maxCount = maxCount;
        this.frameCount = 0;
    }
    public boolean run(){
        if(frameCount >= maxCount){
            return true;
        }else {
            frameCount++;
            return false;
        }
    }
    public  void reset(){
        this.frameCount = 0;
    }
   /* public boolean run(){
        if(frameCount >= maxCount){
            return true;
        }else {
            frameCount++;
            return false;
        }
    }
    public void reset(){
        this.frameCount = 0;
    }*/
}
