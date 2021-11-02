package GUI;

import GUI.AppFrame;
import GUI.SubmitGuessActionThread;
import Interfaces.ICustomAction;

public class SubmitGuessAction  implements ICustomAction  {
    protected AppFrame appframe;
    public SubmitGuessAction(AppFrame appframe) {
        this.appframe=appframe;
    }
    @Override
    public void action() {

        SubmitGuessActionThread submitGuessActionThread = new SubmitGuessActionThread(appframe);
        submitGuessActionThread.start();




    }
}
