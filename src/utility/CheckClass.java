package utility;

public class CheckClass {

    public boolean isGameWon(int pos){ //inside function call use CounterClass.positionCounter (4 correct positions = won game)
        if(pos==4)
            return true;
        else return false;
    }
    public boolean anyTriesLeft(int currentRow){ //call with the row of tries you are on
        if(currentRow>11)
            return false;
            else return true;
    }
}