package backtrcking;


// Subset sum problem without backtracking
public class SubsetSumWithoutBT {

    private static int totalNode = 0;
    public static void main(String[] args) {
        int[] weights = {10, 7, 5, 18, 12, 20, 15};
        int targetSum = 35;
        generateSubSet(weights, targetSum);
        System.out.println("total node generated: " + totalNode);
        
    }

    private static void generateSubSet(int[] weights, int targetSum) {
         int[] tupletVector = new int[weights.length];
         subsetSum(weights, tupletVector, 0, 0, 0, targetSum);
    }

        private static void subsetSum(int[] weights, int[] tupletVector, int tupletVectorSize, int sumSoFar, int nodeCount,final int targetSum) {

        totalNode++;
        if (targetSum == sumSoFar) {
            //we found the subset
            for (int i = 0; i < tupletVectorSize; i++) {
                System.out.printf(tupletVector[i] + " ");
            }
            System.out.println();
            subsetSum(weights, tupletVector, tupletVectorSize -1, sumSoFar - weights[nodeCount], nodeCount + 1, targetSum);
            return;
        }
        else {
            for (int i = nodeCount; i < weights.length; i++) {
                tupletVector[tupletVectorSize] = weights[i];
                subsetSum(weights, tupletVector, tupletVectorSize + 1, sumSoFar + weights[i], i+1, targetSum);
            }
        }
    }
}
