import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 문자열처리_MostCommonChar {
    public static char mostCommonChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>(); // 문자별 등장 횟수를 저장할 해시맵

        // 문자열의 각 문자를 순회하며 개수를 카운팅
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // 가장 많이 등장한 문자 찾기
        return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        System.out.println(mostCommonChar("hello world")); // → 'l'
    }
}
