package utilitymethods;

import Interfaces.ICheckClass;

public class CheckClass implements ICheckClass {
    public boolean anyTriesLeft(int currentRow){ //call with the row of tries you are on
        if(currentRow>8)
            return false;
        else return true;
    }
}