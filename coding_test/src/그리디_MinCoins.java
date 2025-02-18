import java.util.*;

public class 그리디_MinCoins {
    public static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins); // 동전을 오름차순 정렬
        int count = 0;

        // 가장 큰 동전부터 사용하여 최소 개수로 거스름돈 계산
        for (int i = coins.length - 1; i >= 0; i--) {
            count += amount / coins[i]; // 해당 동전으로 몇 개 사용할 수 있는지 계산
            amount %= coins[i]; // 남은 금액 업데이트
        }
        return amount == 0 ? count : -1; // 거스름돈이 정확히 맞아떨어지면 count 반환, 그렇지 않으면 -1 반환
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int[]{1, 5, 10, 50}, 127)); // → 5
    }
}
