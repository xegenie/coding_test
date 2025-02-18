import java.util.*;

public class 해시맵_SingleNumber {
    public static List<Integer> singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(); // 숫자의 등장 횟수를 저장할 맵

        // 배열을 순회하면서 각 숫자의 개수 저장
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 한 번만 등장하는 숫자들을 리스트에 추가
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 3, 2, 3, 4, 6, 2})); // → [6]
    }
}
