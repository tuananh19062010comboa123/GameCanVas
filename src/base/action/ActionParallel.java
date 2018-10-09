package base.action;

import base.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionParallel extends Action {
    ArrayList<Action> actions;
    public ActionParallel(Action ... actions){
        this.actions = new ArrayList<>(Arrays.asList(actions));// gan tu mang sang arraylis - [] -> arrylist>
    }

    @Override
    public void run(GameObject master) {
    if(this.actions.size() > 0
            && !this.isDone){
        boolean isContinue = true;
        for (Action action : actions){
            if(!action.isDone){
                action.run(master);
            }
            action.run(master);
        }
        this.isDone = !isContinue;
    }

    }

    @Override
    public void reset() {
        for(Action action : actions){
            action.reset();
        }
        this.isDone = false;
    }
}
