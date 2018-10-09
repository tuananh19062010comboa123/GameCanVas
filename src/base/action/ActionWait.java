package base.action;

import base.GameObject;
import base.counter.FrameCount;

public class ActionWait extends Action{
    FrameCount counter;
    public ActionWait(int frame){
        this.isDone = false;
        this.counter = new FrameCount(frame);
    }



    @Override
    public void run(GameObject master) {
        if(this.counter.run()) {
            this.isDone = true;
        }
    }

    @Override
    public void reset() {
        this.counter.reset();
        this.isDone = false;
    }

}
