public class Currency {

    public static void coinChange(int amount) {
        int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int[] counts = new int[denominations.length];
        int changeAmount=amount;

        for (int i = 0; i < denominations.length; i++) {
            counts[i] = amount / denominations[i];
            amount %= denominations[i];
        }

        System.out.println("Denominations for Rs. " + changeAmount + ":");
        System.out.println();
        for (int i = 0; i < denominations.length; i++) {
            if (counts[i] > 0) {
                System.out.println(counts[i] + " x Rs. " + denominations[i] + "=" + " "+ "Rs." +counts[i]*denominations[i]);
            }
        }
    }

    public static void main(String[] args) {
        int amount = 1988;
        coinChange(amount);
    }
}