package suanfa;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return recursion(coins, amount, 0, coins.length - 1);
    }

    /**
     * 金额从大到小，从多到少（对金额进行排序，之后去余数）
     *
     * @param coins
     * @param amount
     * @param count
     * @param index
     * @returnDispatcherServlet
     */
    private static int recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= Integer.MAX_VALUE) {
            return -1;
        }
        if (amount % coins[index] == 0) {
            return amount / coins[index];
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
        return -1;
    }


}
