package utilitymethods;

import Interfaces.ICodeGenerator;

import java.util.*;
public class CodeGenerator implements ICodeGenerator {


    //_wCodex stands for the colour of position X
    private int _wCode1 = 0;
    private int _wCode2 = 0;
    private int _wCode3 = 0;
    private int _wCode4 = 0;
    public void setNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0;i<=5;i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        _wCode1=numbers.get(0);
        _wCode2=numbers.get(1);
        _wCode3=numbers.get(2);
        _wCode4=numbers.get(3);
    }
    public int get_wCode1() {
        return _wCode1;
    }

    public int get_wCode2() {
        return _wCode2;
    }

    public int get_wCode3() {
        return _wCode3;
    }

    public int get_wCode4() {
        return _wCode4;
    }


}
