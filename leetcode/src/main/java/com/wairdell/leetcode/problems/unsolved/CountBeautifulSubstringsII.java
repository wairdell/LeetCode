package com.wairdell.leetcode.problems.unsolved;

import java.util.HashMap;
import java.util.Map;

/**
 * date   : 2024/5/6 16:10
 * desc   : 统计美丽子字符串 II https://leetcode.cn/problems/count-beautiful-substrings-ii
 */
public class CountBeautifulSubstringsII {

    public static void main(String[] args) {
        CountBeautifulSubstringsII substringsII = new CountBeautifulSubstringsII();
//        System.out.println(substringsII.beautifulSubstrings("baeyh", 2));
//        System.out.println(substringsII.beautifulSubstrings("abba", 1));
//        System.out.println(substringsII.beautifulSubstrings("bcdf", 1));
//        System.out.println(substringsII.beautifulSubstrings("ouuoeqd", 2));
//        System.out.println(substringsII.beautifulSubstrings("pulorolqcvhafexui", 9));
//        System.out.println(substringsII.beautifulSubstrings("svzauyuevujektj", 5));
        System.out.println(substringsII.beautifulSubstrings("zermimniolynzdkeioiddrhuarohgfurgfzgevmecziuafaubwmudamdepooecaeatcuwuojuiihaefcuaa", 27));
    }

    private int findBase(int k) {
        for (int i = 2; i < k; i++) {
            int half = k / 2;
            if ((half * half) % k == 0) {
                return half;
            }
        }
        return k;
    }

    public long beautifulSubstrings(String s, int k) {
        Map<String, Integer> previousMap = new HashMap<>();
        int ans = 0;
        int vowels = 0;
        int consonants = 0;
        previousMap.put("0,0", 1);
        double sqrt = Math.sqrt(k);
        int half = k / 2;
        int base = k;
        if (sqrt - ((int) sqrt) < 1e-9 ) {
            base = (int) sqrt;
        } else if ((half * half) % k == 0) {
            base = k / 2;
        } else {
            base = findBase(k);
        }
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u') {
                vowels++;
            } else {
                consonants++;
            }
            if (vowels > consonants) {
                int rem = consonants % base;
                int j = 0;
                while (consonants - rem - j * base >= 0) {
                    int target = consonants - rem - j * base;
                    int findVowels = vowels - target;
                    int findConsonants = consonants - target;
                    if (findVowels < 0 || findConsonants < 0) break;
                    if (target * target % k == 0 && previousMap.containsKey(findVowels + "," + findConsonants)) {
                        ans += previousMap.get(findVowels + "," + findConsonants);
                    }
                    j++;
                }
            } else {
                int rem = vowels % base;
                int j = 0;
                while (vowels - rem - j * base >= 0) {
                    int target = vowels - rem - j * base;
                    j++;
                    int findVowels = vowels - target;
                    int findConsonants = consonants - target;
                    if (findVowels < 0 || findConsonants < 0) continue;
                    if (target * target % k == 0 && previousMap.containsKey(findVowels + "," + findConsonants)) {
                        ans += previousMap.get(findVowels + "," + findConsonants);
                    }
                }
            }
            String key = vowels + "," + consonants;
            previousMap.put(key, previousMap.getOrDefault(key, 0) + 1);
        }
        return ans;
    }

}
