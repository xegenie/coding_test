import java.util.*;

public class 우선순위큐_KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 생성

        // 모든 숫자를 힙에 추가
        for (int num : nums) {
            pq.add(num);
        }

        // K번째 큰 숫자를 찾기 위해 K-1번 삭제 후 최댓값 반환
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll(); // K번째 큰 값 반환
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // → 5
    }
}
