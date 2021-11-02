package Classes;

import GUI.AppFrame;

import java.io.File;
import java.io.FileWriter;

public class SaveThread extends Thread{
    AppFrame appframe;
    public SaveThread(AppFrame appframe)
    {
        this.appframe=appframe;
    }
    public void run() {
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.append("--Targets--\n");
            for(int i=0;i<4;++i) {
                writer.write(appframe.getTargetBalls()[i].toString());
            }
            writer.append("--Hints--\n");
            for(int i=0;i<10;++i)
            {
                for(int j=0;j<2;++j)
                {
                    for(int k=0;k<2;++k)
                    {
                        writer.append(appframe.getHints()[i][j][k].toString());
                    }
                }
            }
            writer.append("--Guest balls--\n");
            for(int i=0;i<4;++i)
            {
                for(int j=0;j<10;++j)
                {
                    writer.append(appframe.getGuessBalls()[i][j].toString());
                }
            }
            writer.append("--Current row--\n");
            writer.append(String.valueOf(appframe.getCurrentRow()));
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Succes!");
        }

    }
}