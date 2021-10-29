package Classes;

public class Ball {
    protected static final int COLOR_RED = 0;
    protected static final int COLOR_BLUE = 1;
    protected static final int COLOR_GREEN = 2;
    protected static final int COLOR_YELLOW = 3;
    protected static final int COLOR_TURQUOISE = 4;
    protected static final int COLOR_PURPLE = 5;
    private int _color;
    public Ball()
    {

    }
    public Ball(int color)
    {
        _color=color;
    }
    public void set_color(int color)
    {
        _color=color;
    }
    public int get_color()
    {
        return _color;
    }
    @Override
    public String toString()
    {
        return "Ball Color: " + checkColor();
       // return "Ball Color: " + _color;
    }
    public String checkColor()
    {
        String st="";
        if(_color==COLOR_RED)
        {
            st = "red";
        }
        else if(_color==COLOR_BLUE)
        {
            st = "blue";
        }
        else if(_color==COLOR_GREEN)
        {
            st = "green";
        }
        else if(_color==COLOR_YELLOW)
        {
            st = "yellow";
        }
        else if(_color==COLOR_TURQUOISE)
        {
            st = "turquoise";
        }
        else if(_color==COLOR_PURPLE)
        {
            st = "purple";
        }
        return st;
    }
}

