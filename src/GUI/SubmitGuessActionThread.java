package GUI;

import GUI.AppFrame;
import utilitymethods.CheckClass;
import utilitymethods.CounterClass;

import javax.swing.*;
import java.io.IOException;

public class SubmitGuessActionThread extends Thread {
    AppFrame appframe;

    public SubmitGuessActionThread(AppFrame appframe) {
        this.appframe = appframe;
    }

    CheckClass checkClass = new CheckClass();
    CounterClass counterClass = new CounterClass();
    int clr;
    int pos;


    public void run() {
         {
             clr = counterClass.colourCounter(appframe.guessBalls[0][appframe.getCurrentRow()].color, appframe.guessBalls[1][appframe.getCurrentRow()].color, appframe.guessBalls[2][appframe.getCurrentRow()].color, appframe.guessBalls[3][appframe.getCurrentRow()].color, appframe.targetBalls[0].color, appframe.targetBalls[1].color, appframe.targetBalls[2].color, appframe.targetBalls[3].color);
             pos = counterClass.positionCounter(appframe.guessBalls[0][appframe.getCurrentRow()].color, appframe.guessBalls[1][appframe.getCurrentRow()].color, appframe.guessBalls[2][appframe.getCurrentRow()].color, appframe.guessBalls[3][appframe.getCurrentRow()].color, appframe.targetBalls[0].color, appframe.targetBalls[1].color, appframe.targetBalls[2].color, appframe.targetBalls[3].color);
             if (pos == 4) {
                 appframe.targetCover.setVisible(false);
                 appframe.guessButton.setText("YOU WON");
                 appframe.setCurrentRow(10);
                appframe.guessButton.removeActionListener(appframe.guessButton.getActionListeners()[0]);
                 for(int i=0;i<4;i++)
                     appframe.guessBalls[i][appframe.currentRow-1].modifiable=false;

                 return;
             }
             if (checkClass.anyTriesLeft(appframe.getCurrentRow()) == true) {
                for(int i=0;i<2;i++)
                    for(int j=0;j<2;j++)
                    { appframe.hints[appframe.getCurrentRow()][i][j].color=8;
                        appframe.hints[appframe.getCurrentRow()][i][j].setVisible(true);
                    }
                int posaux=pos;
                    int clraux=clr;
                for(int i=0;i<2;i++)
                    for(int j=0;j<2;j++) {
                        if(posaux!=0) {
                            appframe.hints[appframe.getCurrentRow()][i][j].color=6;
                            appframe.hints[appframe.getCurrentRow()][i][j].setColor();
                            posaux--;
                            clraux--;
                        }
                        else
                            if(clraux!=0){
                                appframe.hints[appframe.getCurrentRow()][i][j].color=7;
                                appframe.hints[appframe.getCurrentRow()][i][j].setColor();
                                clraux--;
                        }
                            else
                                if(clraux==0 && posaux==0)
                                    appframe.hints[appframe.getCurrentRow()][i][j].color=8;
                                    appframe.hints[appframe.getCurrentRow()][i][j].setColor();
                    }


                 for(int i=0;i<4;i++)
                     appframe.guessBalls[i][appframe.currentRow].modifiable=false;
                 appframe.setCurrentRow(appframe.getCurrentRow() + 1);

                 for(int i=0;i<4;i++)
                     appframe.guessBalls[i][appframe.getCurrentRow()].setVisible(true);

            }
            else
                    appframe.getGuessButton().setText("YOU ARE OUT OF TRIES");

        }


    }
}
