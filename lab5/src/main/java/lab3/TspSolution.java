package lab3;

public class TspSolution {
    // any required fields and methods
    int[] item;

    public int len(){
        return item.length;
    }

    public int get(int idx){
        return item[idx];
    }

    public boolean contains(int obj){
        for (int i = 0; i< item.length; i++){
            if (item[i] == obj){
                return true;
            }
        }
        return false;
    }

    public String ToString(){
        String res = "[ " + item[0];
        for (int i = 1; i< item.length; i++){
            res +=  ", " + item[i] ;
        }
        res += " ]";
        return res;
    }
}
