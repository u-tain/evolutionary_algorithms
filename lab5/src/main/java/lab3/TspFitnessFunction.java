package lab3;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.List;

public class TspFitnessFunction implements FitnessEvaluator<TspSolution> {
    private int dimension;
    public TspFitnessFunction(int dimension) {
        this.dimension = dimension;
    }

    public double getFitness(TspSolution solution, List<? extends TspSolution> list) {
        int conflict = 0;
        for (int i = 0; i<dimension-1; i++) {
            for (int j = i + 1; j < dimension; j++) {
                if (j - i == Math.abs(solution.get(j) - solution.get(i))) {
                    conflict += 1;
                }
            }
        }

        return conflict;
    }

    public boolean isNatural() {
        return false;
    }
}
