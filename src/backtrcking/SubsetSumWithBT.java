package backtrcking;

import java.util.Arrays;

public class SubsetSumWithBT {

    private static int total_iteration = 0;

    public static void main(String[] args) {
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        int targetSum = 35;

        findSubSet(weights, targetSum);
        System.out.println(total_iteration);
    }

    private static void findSubSet(int[] weights, int targetSum) {

        int[] solution_vector = new int[weights.length];
        Arrays.sort(weights);

        int total = 0;
        for (int weight : weights) {
            total += weight;
        }
        int sizeOfSV = 0;
        int presentNode = 0;
        int sumSoFar = 0;

        if (weights[0] <= targetSum && targetSum <= total)
            solveSubSet(weights, solution_vector, sizeOfSV, presentNode, sumSoFar, targetSum);
    }

    private static void solveSubSet(int[] weights, int[] solution_vector, int sizeOfSV, int presentNode, int sumSoFar, int targetSum) {

        total_iteration++;
        if (sumSoFar == targetSum) {
            printSolution(solution_vector, sizeOfSV);

            // We have found the solution so we will ignore the presentNode and consider the next node
            if (presentNode + 1 < weights.length && sumSoFar - weights[presentNode] + weights[presentNode + 1] <= targetSum) {
                solveSubSet(weights, solution_vector, sizeOfSV - 1, presentNode + 1, sumSoFar - weights[presentNode], targetSum);
            }
        }
        else {
            if (presentNode < weights.length && sumSoFar + weights[presentNode] <= targetSum) {

                for (int i = presentNode; i < weights.length; i++) {

                    solution_vector[sizeOfSV] = weights[i];
                    
                    if (sumSoFar + weights[i] <= targetSum)
                        solveSubSet(weights, solution_vector, sizeOfSV + 1, i + 1, sumSoFar + weights[i], targetSum);
                }
            }
        }
    }

    private static void printSolution(int[] solution_vector, int sizeOfSV) {
        for (int i = 0; i < sizeOfSV; i++) {
            System.out.printf(solution_vector[i] + " ");
        }
        System.out.println();
    }
}
