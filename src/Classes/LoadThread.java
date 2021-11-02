package Classes;

import GUI.AppFrame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class LoadThread extends Thread {
    AppFrame appframe;
    public LoadThread(AppFrame appframe)
    {
        this.appframe=appframe;
    }

    public void run() {
        String garbage;
        String buffer = "";
        int readColor;
        try {
            FileReader reader = new FileReader("save.txt");
            Scanner scanner = new Scanner(reader);
            garbage = scanner.next();
            for(int i=0;i<4;++i) {
                garbage = scanner.next();
                readColor = scanner.nextInt();
                appframe.getTargetBalls()[i].color = readColor;
                appframe.getTargetBalls()[i].setColor();
            }
            garbage = scanner.next();
            for(int i=0;i<10;++i){
                for(int j=0;j<2;++j) {
                    for(int k=0;k<2;++k) {
                        garbage = scanner.next();
                        readColor = scanner.nextInt();
                        appframe.getHints()[i][j][k].color = readColor;
                        appframe.getHints()[i][j][k].setColor();
                    }
                }
            }
            garbage = scanner.next();
            garbage = scanner.next();
            for(int i=0;i<4;++i) {
                for(int j=0;j<10;++j) {
                    garbage = scanner.next();
                    readColor = scanner.nextInt();
                    appframe.getGuessBalls()[i][j].color = readColor;
                    appframe.getGuessBalls()[i][j].setColor();
                }
            }
            garbage = scanner.next();
            garbage = scanner.next();
            appframe.setCurrentRow(scanner.nextInt());
            for (int i = 0; i < appframe.getCurrentRow() + 1; ++i) {
                if (i != appframe.getCurrentRow()) {
                    for (int j = 0; j < 2; ++j) {
                        for (int k = 0; k < 2; ++k) {
                            appframe.getHints()[i][j][k].setVisible(true);
                        }
                    }
                }
                for (int j = 0; j < 4; ++j) {
                    appframe.getGuessBalls()[j][i].setVisible(true);
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
