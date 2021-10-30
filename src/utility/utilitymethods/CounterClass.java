package utility.utilitymethods;

public class CounterClass {
        public int positionCounter(int c1,int c2,int c3,int c4,int pc1,int pc2,int pc3, int pc4){//cx= colour from position x, pcx= picked colour from position x replace cx with colour [i][j] and pcx with CodeGenerator _getCodewx
        int poscounter =0;
            if(c1==pc1)
                poscounter++;
            if(c2==pc2)
                poscounter++;
            if(c3==pc3)
                poscounter++;
            if(c4==pc4)
                poscounter++;
            return poscounter;

        }
        public int colourCounter(int c1,int c2,int c3,int c4,int pc1,int pc2,int pc3,int pc4 ){ //can call colourCounter with the same parameters as positionCounter
            int clrcounter=0;
            if(c1==pc1||c1==pc2||c1==pc3||c1==pc4)
                clrcounter++;
            if(c2==pc1||c2==pc2||c2==pc3||c2==pc4)
                clrcounter++;
            if(c3==pc1||c3==pc2||c3==pc3||c3==pc4)
                clrcounter++;
            if(c4==pc1||c4==pc2||c4==pc3||c4==pc4)
                clrcounter++;
            return clrcounter;
        }




}
