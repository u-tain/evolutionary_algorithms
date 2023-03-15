package lab3;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TspCrossover extends AbstractCrossover<TspSolution> {
    protected TspCrossover() {
        super(1);
    }

    protected List<TspSolution> mate(TspSolution p1, TspSolution p2, int i, Random random) {
        ArrayList children = new ArrayList();
        // your implementation:
        // i - количество подряд идущих генов, которые будут меняться
        // сгенерируем
        int length = p1.len();
        int idx1 = random.nextInt(length-i); // генерируем стартовый индекс
        i = 2;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int j = 0; j < i; j++) {
            indexes.add(idx1 + j);
        }
        TspSolution ch1 = new TspSolution();
        ch1.item = new int[length];
        TspSolution ch2 = new TspSolution();
        ch2.item = new int[length];
        int[] h1 = new int[length];
        int[] h2 = new int[length];
        ArrayList<Integer> stay1 = new ArrayList<Integer>();
        ArrayList<Integer> stay2 = new ArrayList<Integer>();

        for (int j = 0; j < length; j++) {
            if (j < i){
                stay1.add(p1.get(idx1 + j));
                stay2.add(p2.get(idx1 + j));
            }
            if (idx1 + j < length) {
                h1[j] = p1.get(idx1 + j);
                h2[j] = p2.get(idx1 + j);
            }
            else {
                h1[j] = p1.get(j - length+idx1);
                h2[j] = p2.get(j - length+idx1);
            }
        }
        int k1 = 0;
        int k2 = 0;
        for (int j = 0; j < length; j++) {
            if (!indexes.contains(j)) {
                while (stay1.contains(h2[k1])){
                    k1+=1;
                }
                ch1.item[j] = h2[k1];
                k1+=1;
                while (stay2.contains(h1[k2])){
                    k2+=1;
                }
                ch2.item[j] = h1[k2];
                k2+=1;
            }
            else
            {
                ch1.item[j] = p1.get(j);
                ch2.item[j] = p2.get(j);
            }
        }
//        System.out.println(ch1.ToString());
//        System.out.println(ch2.ToString());
        children.add(ch1);
        children.add(ch2);
        return children;
    }
}
