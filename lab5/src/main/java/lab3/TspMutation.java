package lab3;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TspMutation implements EvolutionaryOperator<TspSolution> {
    public List<TspSolution> apply(List<TspSolution> population, Random random) {
        double p1 = 0.03;
        for (int i = 0; i < population.size(); i++) {
            if (random.nextDouble()<p1){
                //мутируем
//                System.out.println(population.get(i).ToString());
                population.set(i, permutation(population.get(i), random));
//                System.out.println(population.get(i).ToString());
                }
            }

        // your implementation:
        return population;
    }

    private TspSolution permutation(TspSolution solution, Random random){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int i = random.nextInt(solution.len());
        int j = i;
        indexes.add(i);
        while (indexes.contains(j)){
            j = random.nextInt(solution.len());
        }
        int el1 = solution.get(i);
        int el2 = solution.get(j);
        solution.item[i] = el2;
        solution.item[j] = el1;
//        System.out.println(i + " " + j);
        return solution;
    }
}
