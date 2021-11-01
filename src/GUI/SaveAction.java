package GUI;

import Classes.SaveThread;
import Interfaces.ICustomAction;

public class SaveAction implements ICustomAction {

    AppFrame appFrame;

    public SaveAction(AppFrame appFrame) {
        this.appFrame = appFrame;
    }
    @Override
    public void action() {
        SaveThread saveThread = new SaveThread(appFrame);
        saveThread.start();




    }
}