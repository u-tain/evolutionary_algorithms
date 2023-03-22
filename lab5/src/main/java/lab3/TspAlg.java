package lab3;

import org.uncommons.watchmaker.framework.*;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TspAlg {

    public static void main(String[] args) {
        int problem_size = 100;
        int populationSize = 150; // size of population
        int generations = 10000; // number of generations

        Random random = new Random(); // random

        CandidateFactory<TspSolution> factory = new TspFactory(problem_size); // generation of solutions

        ArrayList<EvolutionaryOperator<TspSolution>> operators = new ArrayList<EvolutionaryOperator<TspSolution>>();
        operators.add(new TspCrossover()); // Crossover
        operators.add(new TspMutation()); // Mutation
        EvolutionPipeline<TspSolution> pipeline = new EvolutionPipeline<TspSolution>(operators);

        SelectionStrategy<Object> selection = new RouletteWheelSelection(); // Selection operator

        FitnessEvaluator<TspSolution> evaluator = new TspFitnessFunction(problem_size); // Fitness function

        EvolutionEngine<TspSolution> algorithm = new SteadyStateEvolutionEngine<TspSolution>(
                factory, pipeline, evaluator, selection, populationSize, false, random);

        algorithm.addEvolutionObserver(new EvolutionObserver() {
            public void populationUpdate(PopulationData populationData) {
                double bestFit = populationData.getBestCandidateFitness();
                if (populationData.getGenerationNumber()%100 == 0) {
                    System.out.println("Generation " + populationData.getGenerationNumber() + ": " + bestFit);
                    TspSolution best = (TspSolution) populationData.getBestCandidate();
                    System.out.println("\tBest solution = " + best.ToString());
                }
            }
        });

        TerminationCondition terminate = new GenerationCount(generations);
        algorithm.evolve(populationSize, 50, terminate);
    }
}
