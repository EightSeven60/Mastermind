package GUI;

import Classes.SaveThread;
import Interfaces.ICustomAction;
import GUI.AppFrame;

public class SubmitGuessAction implements ICustomAction {
    @Override
    public void action() {
        AppFrame appframe;
        SubmitGuessActionThread submitGuessActionThread = new SubmitGuessActionThread(appframe);
        submitGuessActionThread.start();




    }
}
