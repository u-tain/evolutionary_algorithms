package lab5;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    public List<double[]> apply(List<double[]> population, Random random) {
        double p1 = 1./population.size();
        double p2 = 1./population.get(0).length;
        for (int i = 0; i < population.size(); i++) {
            if (random.nextDouble()<p1){
                //мутируем
                for (int j = 0; j < population.get(i).length; j++){
                    if (random.nextDouble()<p2){
                        population.get(i)[j] = random.nextDouble() * 10 - 5;
                    }
                }
            }
        }
        return population;
    }
}
