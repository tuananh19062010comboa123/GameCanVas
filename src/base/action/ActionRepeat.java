package base.action;

import base.GameObject;

public class ActionRepeat extends Action {
    Action action;

    public ActionRepeat (Action action){
        this.action = action;
    }
    @Override
    public void run(GameObject master) {
        if(!this.action.isDone){
            action.run(master);
        }else {
            action.reset();
        }
    }

    @Override
    public void reset() {//vi no chay lien tuc nen ko co reset()

    }
}
