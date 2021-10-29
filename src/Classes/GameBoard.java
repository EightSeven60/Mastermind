package Classes;

import java.util.Scanner;

public class GameBoard {
    private Row[] _rows_of_balls;
    public GameBoard()
    {

    }
    public GameBoard(Row[] rows_of_balls )
    {
         _rows_of_balls=rows_of_balls;
    }
    public void set_rows_of_balls()
    {
        _rows_of_balls = new Row[10];
    }
    public Row[] get_rows_of_balls()
    {
        return _rows_of_balls;
    }
    public void instantiate_rows_of_balls(Scanner sc)
    {
        for(int k=0;k<10;++k)
        {
             _rows_of_balls[k] = new Row();
             _rows_of_balls[k].set_row();
             _rows_of_balls[k].set_hints();
             _rows_of_balls[k].instantiate_row(sc);
             _rows_of_balls[k].instantiate_hints(sc);
        }
    }
}
