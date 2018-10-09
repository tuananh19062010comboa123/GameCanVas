package base.action;

import base.GameObject;

public abstract class Action {// Chu yeu dung isDone va function reset de quan ly cho function run ()
    public boolean isDone;
    public abstract void run(GameObject master);
    public abstract void reset();
}
