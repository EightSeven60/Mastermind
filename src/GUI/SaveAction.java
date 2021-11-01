package GUI;

import Classes.SaveThread;
import Interfaces.ICustomAction;

public class SaveAction implements ICustomAction {
    @Override
    public void action() {
        SaveThread saveThread = new SaveThread();
        saveThread.start();




    }
}