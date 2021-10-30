package Classes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Row extends Instantiate{
    private Ball[] _row;
    private Ball[][] _hints;
    public Row()
    {

    }
    public Row(Ball[][] hints,Ball[]row)
    {
       _hints=hints;
       _row=row;
    }
    public void set_row()
    {
        _row = new Ball[4];
    }
    public void set_hints()
    {
        _hints = new Ball[2][2];
    }
    public Ball[] get_row()
    {
        return _row;
    }
    public Ball[][] get_hints()
    {
        return _hints;
    }
    public void instantiate_row(Scanner sc)
    {
        for(int i=0;i<4;++i)
        {
            Random rd = new Random();
            int c = rd.nextInt(6);
            if(c==0)
            {
                _row[i] = new Ball(Ball.COLOR_RED);
            }
            else if(c==1)
            {
                _row[i] = new Ball(Ball.COLOR_BLUE);
            }
            else if(c==2)
            {
                _row[i] = new Ball(Ball.COLOR_GREEN);
            }
            else if(c==3)
            {
                _row[i] = new Ball(Ball.COLOR_YELLOW);
            }
            else if(c==4)
            {
                _row[i] = new Ball(Ball.COLOR_TURQUOISE);
            }
            else if(c==5)
            {
                _row[i] = new Ball(Ball.COLOR_PURPLE);
            }
            else
            {
                return;
            }
        }
        for(int i=0;i<4;++i)
        {
            System.out.println("Color: "+_row[i].get_color());
            System.out.println(_row[i].toString());
        }
    }
    public void instantiate_hints(Scanner sc)
    {
        for(int i=0;i<2;++i)
        {
            for(int j=0;j<2;++j)
            {
                Random r = new Random();
                int s = r.nextInt(2)+6;
                if(s==6)
                {
                    _hints[i][j] = new Ball(Ball.COLOR_WHITE);
                }
                else if(s==7)
                {
                    _hints[i][j] = new Ball(Ball.COLOR_BLACK);
                }
                else
                {
                    return;
                }
            }
        }
        for(int i=0;i<2;++i)
        {
            for(int j=0;j<2;++j)
            {
                System.out.println("Color: " +_hints[i][j].get_color());
                System.out.println(_hints[i][j].toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Row{" +
                "_row=" + Arrays.toString(_row) +
                ", _hints=" + Arrays.toString(_hints) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Arrays.equals(_row, row._row) && Arrays.equals(_hints, row._hints);
    }
}
