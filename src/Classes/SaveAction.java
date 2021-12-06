package Classes;

import Classes.SaveThread;
import GUI.AppFrame;
import Interfaces.ICustomAction;

public class SaveAction implements ICustomAction {

    protected AppFrame appframe;

    public SaveAction(AppFrame appframe) {
        this.appframe = appframe;
    }

    @Override
    public void action() {
        SaveThread saveThread = new SaveThread (appframe);
        saveThread.start();
    }
}