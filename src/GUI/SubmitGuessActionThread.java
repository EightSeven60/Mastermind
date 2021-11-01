package GUI;

import GUI.AppFrame;
import utilitymethods.CheckClass;
import utilitymethods.CounterClass;

public class SubmitGuessActionThread extends Thread {
    AppFrame appframe;

    public SubmitGuessActionThread(AppFrame appframe) {
        this.appframe = appframe;
    }
    CheckClass checkClass= new CheckClass();
    CounterClass counterClass= new CounterClass();
    int clr;
    int pos;


    public void run(){
        if(checkClass.anyTriesLeft(appframe.getCurrentRow())==true) {
            clr = counterClass.colourCounter(appframe.guessBalls[0][appframe.getCurrentRow()].color, appframe.guessBalls[1][appframe.getCurrentRow()].color, appframe.guessBalls[2][appframe.getCurrentRow()].color, appframe.guessBalls[3][appframe.getCurrentRow()].color, appframe.targetBalls[0].color, appframe.targetBalls[1].color, appframe.targetBalls[2].color, appframe.targetBalls[3].color);
            pos= counterClass.positionCounter(appframe.guessBalls[0][appframe.getCurrentRow()].color, appframe.guessBalls[1][appframe.getCurrentRow()].color, appframe.guessBalls[2][appframe.getCurrentRow()].color, appframe.guessBalls[3][appframe.getCurrentRow()].color, appframe.targetBalls[0].color, appframe.targetBalls[1].color, appframe.targetBalls[2].color, appframe.targetBalls[3].color);
            while(clr!=0)
            {
                for(int i=0;i<2;i++)
                    for(int j=0;j<2;j++)
                    {
                        appframe.hints[appframe.getCurrentRow()][i][j].setVisible(true);
                        clr--;
                    }
            }
            while(pos!=0)
            {
                for(int i=0;i<2;i++)
                    for(int j=0;j<2;j++)
                    {
                        appframe.hints[appframe.getCurrentRow()][i][j].setVisible(true);
                        pos--;
                    }
            }
            appframe.setCurrentRow(appframe.getCurrentRow()+1);
            if(pos==4)
            {

            }
        }

    }

}

