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
        int length = p1.len();

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        TspSolution ch1 = new TspSolution();
        ch1.item = new int[length];
        TspSolution ch2 = new TspSolution();
        ch2.item = new int[length];
        ArrayList<Integer> h1 = new ArrayList<Integer>();
        ArrayList<Integer> h2 = new ArrayList<Integer>();

        for (int j = 0; j<length; j++){
            if (p1.get(j)==p2.get(j)){
                indexes.add(j);
                h1.add(p1.get(j));
                h2.add(p2.get(j));
            }
        }

        int new1 = random.nextInt(length);
        int new2 = random.nextInt(length);
        for (int j =0; j<length;j++){
            if (!indexes.contains(j)){
                while (h1.contains(new1)){
                    new1 = random.nextInt(length);
                }
                ch1.item[j] = new1;
                h1.add(new1);

                while (h2.contains(new2)){
                    new2 = random.nextInt(length);
                }
                ch2.item[j] = new2;
                h2.add(new2);
            }
            else {
                ch1.item[j] = p1.get(j);
                ch2.item[j] = p2.get(j);
            }
        }
//        System.out.println(p1.ToString());
//        System.out.println(p2.ToString());
//
//        System.out.println(ch1.ToString());
//        System.out.println(ch2.ToString());
        children.add(ch1);
        children.add(ch2);
        return children;
    }
}
