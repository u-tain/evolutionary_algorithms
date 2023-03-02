package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList children = new ArrayList();
        // генерируем индексы
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < i) {
            int r = random.nextInt(p1.length);
            if (!numbers.contains(r)) {
                numbers.add(r);
            }
        }

        // your implementation:
        double[] ch1 = p1.clone();
        double[] ch2 = p2.clone();
        double alpha = 1;
        for (int j = 0; j < i; j++) {
            ch1[numbers.get(j)] = alpha * ch2[numbers.get(j)] + (1 - alpha) * ch1[numbers.get(j)];
            ch2[numbers.get(j)] = alpha * ch1[numbers.get(j)] + (1 - alpha) * ch2[numbers.get(j)];
        }
//        children.add(p1);
//        children.add(p2);
        children.add(ch1);
        children.add(ch2);
        return children;
    }
}
