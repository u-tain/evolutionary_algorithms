package lab3;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.ArrayList;
import java.util.Random;

public class TspFactory extends AbstractCandidateFactory<TspSolution> {

    private int dimension;

    public TspFactory(int dimension) {this.dimension = dimension; }

    public TspSolution generateRandomCandidate(Random random) {
        TspSolution solution = new TspSolution();
        solution.item = new int[dimension];
        ArrayList<Integer> h = new ArrayList<Integer>();
        int news = random.nextInt(dimension);
        h.add(news);
        for (int i = 0; i < dimension; i++){
            if (i==0){
                solution.item[i] = news;
            }
            else {
                while (h.contains(news)) {
                    news = random.nextInt(dimension);
                }
                solution.item[i] = news;
                h.add(news);
            }
        }

        return solution;
    }
}
