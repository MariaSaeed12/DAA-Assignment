import java.util.*;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int elements = scanner.nextInt();

        System.out.println("Enter the maximum weight:");
        int max_weight = scanner.nextInt();

        int[] weights = new int[elements];
        int[] benefits = new int[elements];

        System.out.println("Enter the weight and benefit of each element:");
        for (int i = 0; i < elements; i++) {
            System.out.print("Weight of element " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Benefit of element " + (i + 1) + ": ");
            benefits[i] = scanner.nextInt();
        }

        int[][] dp = new int[elements + 1][max_weight + 1];

        for (int i = 1; i <= elements; i++) {
            for (int w = 1; w <= max_weight; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(benefits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("\nDynamic Programming Table:");
        for (int i = 0; i <= elements; i++) {
            for (int w = 0; w <= max_weight; w++) {
                System.out.printf("%-5d", dp[i][w]);
            }
            System.out.println();
        }

        List<Integer> selectedItems = new ArrayList<>();
        int totalBenefit = 0;
        int i = elements, w = max_weight;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(i);
                w -= weights[i - 1];
                totalBenefit += benefits[i - 1];
            }
            i--;
        }

        System.out.println("\nMax benefit that can be chosen from given elements is:"+totalBenefit);


        System.out.println("\nElements selected for maximum value:");
        for (int item : selectedItems) {
            System.out.println("Elements " + item + " (weight: " + weights[item - 1] + ", benefit: " + benefits[item - 1] + ")");
        }
    }
}




