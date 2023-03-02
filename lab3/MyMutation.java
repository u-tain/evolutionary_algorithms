package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {
    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!
        // your implementation:
        // выберем индивидов с вероятностью 1/population size
        double p1 = 1./population.size();
        double p2 = 1./population.get(0).length;
        for (int i = 0; i < population.size(); i++) {
            if (random.nextDouble()<p1){
                //мутируем
                for (int j = 0; j < population.get(i).length; j++){
                    if (random.nextDouble()<p2){
                        population.get(i)[j] = random.nextDouble() * 11 - 5;
                        System.out.println("мутируем");
                        //break;
                    }
                }
            }
        }
        //result population
        return population;
    }
}
