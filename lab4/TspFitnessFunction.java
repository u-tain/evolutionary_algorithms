package lab3;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class TspFitnessFunction implements FitnessEvaluator<TspSolution> {
    HashMap<Integer, Integer[]> problem_info = new HashMap<>();
    public TspFitnessFunction(String problem) {
        try {
            File f = new File(problem);
            Scanner sc = new Scanner(f);
            int flag = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if ("NODE_COORD_SECTION".equals(line)) {
                    flag = 1;
                    line = sc.nextLine();
                }
                if (flag == 1) {
                    if ("EOF".equals(line))
                        continue;
                    String[] strArray = line.split(" ");
                    problem_info.put(Integer.parseInt(strArray[0]), new Integer[]{Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2])});
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double getFitness(TspSolution solution, List<? extends TspSolution> list) {
        double dist = 0;
        int x1, x2,y1,y2;
        for (int i = 1; i < solution.len(); i++){
            x1 = problem_info.get(solution.get(i-1))[0];
            y1 = problem_info.get(solution.get(i-1))[1];
            x2 = problem_info.get(solution.get(i))[0];
            y2 = problem_info.get(solution.get(i))[1];
            dist += Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
        }
        return dist;
    }

    public boolean isNatural() {
        return false;
    }
}
