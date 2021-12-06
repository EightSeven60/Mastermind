package Classes;

import Classes.LoadThread;
import Classes.SaveThread;
import GUI.AppFrame;
import Interfaces.ICustomAction;

public class LoadAction implements ICustomAction {

    protected AppFrame appframe;

    public LoadAction(AppFrame appframe) {
        this.appframe = appframe;
    }

    @Override
    public void action() {
        LoadThread loadThread = new LoadThread (appframe);
        loadThread.start();
    }
}