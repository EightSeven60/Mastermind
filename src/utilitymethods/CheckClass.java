package utilitymethods;

import Interfaces.ICheckClass;

public class CheckClass implements ICheckClass {

    public boolean isGameWon(int pos){ //inside function call use CounterClass.positionCounter (4 correct positions = won game)
        if(pos==4)
            return true;
        else return false;
    }
    public boolean anyTriesLeft(int currentRow){ //call with the row of tries you are on
        if(currentRow>8)
            return false;
        else return true;
    }
}