package lab3;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Random;

public class TspFactory extends AbstractCandidateFactory<TspSolution> {

    public TspSolution generateRandomCandidate(Random random) {
        TspSolution solution = new TspSolution();
        int dimension = 131;
        solution.item = new int[dimension];
        for (int i = 0; i < dimension; i++){
            solution.item[i] = i+1;
        }
        return solution;
    }
}

